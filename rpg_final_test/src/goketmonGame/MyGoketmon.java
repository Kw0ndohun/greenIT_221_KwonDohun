package goketmonGame;

import java.util.ArrayList;
 
public class MyGoketmon {
	static MyGoketmon instance=new MyGoketmon();
	//�� ���ϸ� ����Ʈ
	private ArrayList<Unit> goketmon=UnitManager.instance.getMyGoList();
	//�� ���ϸ� ����â
	private ArrayList<Unit> myParty=new ArrayList<Unit>();
	//�ִ� ��Ƽ��
	private final int MAXPARTY=2;
	
	public ArrayList<Unit> getGoketmon() {
		return goketmon;
	}
	public void setGoketmon(ArrayList<Unit> goketmon) {
		this.goketmon = goketmon;
	}
	public ArrayList<Unit> getMyParty() {
		return myParty;
	}
	public void setMyParty(ArrayList<Unit> myParty) {
		this.myParty = myParty;
	}
	public MyGoketmon() {
		//������ �����ϴ� �� ���� ��Ƽ�� �ְ� ����
		for(int n=0; n<2; n++) {
			myParty.add(goketmon.get(n));
			goketmon.get(n).setParty(true);
		}
	}
	//�� ���ϸ� �޴�
	public void goketmonMenu() {
		while(true) {
			printMyGoketmonList();
			System.out.println("1.���ϸ� �����ֱ� 2.��Ƽ�� �߰� 3.��Ƽ�� ���� 4.����");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				delGoketmon();
			}
			else if(sel==2) {
				addMonForParty();
			}
			else if(sel==3) {
				delMonForParty();
			}
			else {
				break;
			}
		}
	}
	
	//���ϸ� ����Ʈ ���
//	public void printAllGoketmon() {
//		int num=1;
//		for(Unit u:goketmon) {
//			System.out.print("["+num+"]");
//			u.print();
//			num++;
//		}
//	}
	//���ϸ� �����ֱ�
	public void delGoketmon() {
		System.out.println("������ ���ϸ� ����:");
		int sel=GameManager.sc.nextInt()-1;
		if(sel>=0&&goketmon.size()>sel) {
			if(!goketmon.get(sel).isParty()) {
				System.out.println("�����ֱ� �Ϸ�.");
				goketmon.remove(sel);
			}
			else {
				System.out.println("��Ƽ�� �����ؾ� �մϴ�.");
			}
		}
		else {
			System.out.println("�߸��� �����Դϴ�.");
		}
	}
	//�� ���ϸ󸮽�Ʈ ���
	public void printMyGoketmonList() {
		System.out.println("========�� ���ϸ�=========");
		for(int n=0; n<this.goketmon.size(); n++) {
			System.out.print("["+(n+1)+"]");
			this.goketmon.get(n).print();
		}
	}
	//��Ƽ����Ʈ ���
	public void printPartyList() {
		System.out.println("========�� ��Ƽ=========");
		for(int n=0; n<this.myParty.size(); n++) {
			System.out.print("["+(n+1)+"]");
			this.myParty.get(n).print();
		}
	}
	
	//���ϸ� ��Ƽ����
//	public void changeParty() {
//		printPartyList();
//		System.out.println("������ ���ϸ�:");
//		int sel=GameManager.sc.nextInt()-1;
//		if(sel>=0&&sel<myParty.size()) {
//			myParty.remove(sel);
//			printMyGoketmonList();
//			System.out.println("�߰��� ���ϸ�:");
//			sel=GameManager.sc.nextInt()-1;
//			
//		}
//		else {
//			System.out.println("�߸��� �����Դϴ�.");
//		}
//	}
	//��Ƽ ���ϸ� �߰�
	public void addMonForParty() {
		//��Ƽ�� �� ���� �ʾ��� ��
		if(myParty.size()<this.MAXPARTY) {
			printMyGoketmonList();
			System.out.println("�߰��� ���ϸ�:");
			int sel=GameManager.sc.nextInt()-1;
			if(sel>=0&&sel<this.goketmon.size()) {
				if(!goketmon.get(sel).isParty()) {
					goketmon.get(sel).setParty(true);
					this.myParty.add(this.goketmon.get(sel));
					printPartyList();
				}
				else {
					System.out.println("�̹� ��Ƽ�� �Դϴ�.");
				}
			}
			else {
				System.out.println("�߸��� �����Դϴ�.");
			}
		}
		else {
			System.out.println("��Ƽ�� �� á���ϴ�.");
		}
	}
	//��Ƽ ���ϸ� ����
	public void delMonForParty() {
		printPartyList();
		System.out.println("��Ƽ���� ������ ���ϸ�:");
		int sel=GameManager.sc.nextInt()-1;
		if(sel>=0&&sel<myParty.size()) {
			myParty.get(sel).setParty(false);
			myParty.remove(sel);
			printPartyList();
		}
		else {
			System.out.println("�߸��� �����Դϴ�.");
		}
	}
}
