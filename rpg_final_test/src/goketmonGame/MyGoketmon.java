package goketmonGame;

import java.util.ArrayList;
 
public class MyGoketmon {
	static MyGoketmon instance=new MyGoketmon();
	//�� ���ϸ� ����Ʈ
	private ArrayList<Unit> myGoketmon=UnitManager.myGoList;
	//�� ���ϸ� ����â
	
	////
	
	//�� ���ϸ� �޴�
	public void goketmonMenu() {
		while(true) {
			printAllGoketmon();
			System.out.println("1.���ϸ� �����ֱ� 2.���ϸ� ��Ƽ����");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				delGoketmon();
			}
			else if(sel==2) {
				
			}
		}
	}
	
	//���ϸ� ����Ʈ ���
	public void printAllGoketmon() {
		int num=1;
		for(Unit u:myGoketmon) {
			System.out.print("["+num+"]");
			u.print();
			num++;
		}
	}
	//���ϸ� �����ֱ�
	public void delGoketmon() {
		System.out.println("������ ���ϸ� ����:");
		int sel=GameManager.sc.nextInt();
		if(sel>0&&myGoketmon.size()+1>sel) {
			System.out.println("�����ֱ� �Ϸ�.");
			myGoketmon.remove(sel-1);
			printAllGoketmon();
		}
		else {
			System.out.println("�߸��� �����Դϴ�.");
		}
	}
	
	//���ϸ� ��Ƽ����
}
