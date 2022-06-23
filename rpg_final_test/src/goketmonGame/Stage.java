package goketmonGame;

public class Stage {
	//�������õ� ���͸���Ʈ�� �޴� ��� ����Ʈ �ʿ�
	//����
	static Stage instance=new Stage();
	private UnitManager um=UnitManager.instance;
	private MyGoketmon mg=MyGoketmon.instance;
	private boolean run;
	
	public Stage() {
		//���� ����
		um.setMonForStage();
		//���� ������ �� ����Ʈ
	}
	
	public void battle() {
		this.run=true;
		meetMonEffect();
		while(this.run) {
			if(um.getMonList()==null) {
				System.out.println("�¸�!");
				break;
			}
			if(mg.getMyParty()==null) {
				System.out.println("�й�.");
				break;
			}
			printUnit();
			playerTurn();
			monTurn();
		}
		um.getMonList().clear();
	}
	
	public void playerTurn() {
		//��Ƽ�� ����ŭ �� �ο�
		for(int n=0; n<mg.getMyParty().size(); n++) {
			System.out.println("=================[���� �޴�]================");
			System.out.println("1.�ο��   2.���� \n3.���ϸ�   4.����ġ��");
			
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				System.out.println("������ ����� �������ּ��� : ");
				int selMon=GameManager.sc.nextInt()-1;
				if(selMon>=0&&selMon<um.getMonList().size()) {
					mg.getMyParty().get(n).attack(um.getMonList().get(selMon));
					checkDie();
				}
				else {
					System.out.println("�߸��� �����Դϴ�.");
					n--;
					continue;
				}
			}
			else if(sel==2) {
				
			}
			else if(sel==3) {
				
			}
			else {
				int ranNum=GameManager.ran.nextInt(10)+1;
				if(ranNum>3) {
					System.out.println(mg.getMyParty().get(0).getName()+"��(��) �����ƴ�!");
					run=false;
				}
				else {
					System.out.println(mg.getMyParty().get(0).getName()+"��(��) ����ĥ �� ����!");
				}
			}
		}
	}
	
	public void monTurn() {
		for(int n=0; n<um.getMonList().size(); n++) {
			int ranIdx=GameManager.ran.nextInt(mg.getMyParty().size());
			um.getMonList().get(n).attack(mg.getMyParty().get(ranIdx));
			checkDie();
		}
	}
	
	public void printUnit() {
		System.out.println("=================[����]================");
		System.out.println("=================[�� ��Ƽ]================");
		for(int n=0; n<mg.getMyParty().size(); n++) {
			System.out.print("["+(n+1)+"]");
			mg.getMyParty().get(n).print();
		}
		System.out.println("=================[����]================");
		for(int n=0; n<um.getMonList().size(); n++) {
			System.out.print("["+(n+1)+"]");
			um.getMonList().get(n).print();
		}
	}
	
	//���� ������ �� ����Ʈ
	public void meetMonEffect() {
		for(int n=0; n<4; n++) {
			if(n%2==0) {
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
			}
			else {
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
			}
			try {
				Thread.sleep(250);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("���͸� ������!!!");
	}
	
	public void checkDie() {
		for(int n=0; n<um.getMonList().size(); n++) {
			if(um.getMonList().get(n).getHp()==0) {
				um.getMonList().remove(n);
				n--;
			}
		}
		for(int n=0; n<mg.getMyParty().size(); n++) {
			if(mg.getMyParty().get(n).getHp()==0) {
				mg.getMyParty().remove(n);
				n--;
			}
		}
	}
	
	
}
