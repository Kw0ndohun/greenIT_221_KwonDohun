package goketmonGame;

public class Shop {
	//�����۸Ŵ��� ������ ����Ʈ��������
	//���ͺ� �Ǹ�
	//ȸ�������� 
	static Shop instance=new Shop();
	private ItemManager im=ItemManager.instance;
	private Inventory it=Inventory.instance;
	public void sellMenu() {
		while(true) {
			System.out.println("================[������ ����]===============");
			System.out.println("1.���ͺ� : 500��");
			System.out.println("2.��ó�� : 1000��");
			System.out.println("3.����");
			System.out.println("������ ������:");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				it.getInven().add(im.addMonsterBall());
				System.out.println("���ԿϷ�.");
			}
			else if(sel==2) {
				it.getInven().add(im.addPotion());
				System.out.println("���ԿϷ�.");
			}
			else {
				break;
			}
		}
	}
	
	
}
