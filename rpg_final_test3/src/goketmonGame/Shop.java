package goketmonGame;

import item.ItemManager;

public class Shop {
	//�����۸Ŵ��� ������ ����Ʈ��������
	//���ͺ� �Ǹ�
	//ȸ�������� 
	static Shop instance=new Shop();
	//���� ������ �Ŵ����� ����ϴ°� ����.
	private ItemManager im=ItemManager.getInstance();
	//���� �÷��̾ �ͼ� �̿���.
	private Player pl=Player.instance;
	public void sellMenu() {
		while(true) {
			System.out.println("================[������ ����]===============");
			System.out.println("1.���ͺ� : 500��");
			System.out.println("2.��ó�� : 1000��");
			System.out.println("3.����");
			System.out.println("������ ������:");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				pl.getInvenInstance().getInven().add(im.addMonsterBall());
				System.out.println("���ԿϷ�.");
			}
			else if(sel==2) {
				pl.getInvenInstance().getInven().add(im.addPotion());
				System.out.println("���ԿϷ�.");
			}
			else {
				break;
			}
		}
	}
	public static Shop getInstance() {
		return instance;
	}
	public static void setInstance(Shop instance) {
		Shop.instance = instance;
	}
	
	
}
