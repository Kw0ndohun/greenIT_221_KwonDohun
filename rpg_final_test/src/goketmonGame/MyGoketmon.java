package goketmonGame;

import java.util.ArrayList;

public class MyGoketmon {
	//�� ���ϸ� ����Ʈ
	ArrayList<Unit> myGoketmon=UnitManager.myList;
	//�� ���ϸ� ����â
	
	
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
}
