package goketmonGame;

public class StageLobby {
	static StageLobby instance=new StageLobby();
	private MyGoketmon myGo=MyGoketmon.instance;
	
	public void lobbyMenu(){
		while(true) {
			
			System.out.println("===========Lobby===========");
			System.out.println(" 1.��� 2.���� 3.�κ��丮 4.�� ���ϸ� 5.���� ");
			System.out.println(" : ");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
	//			StageBattle();
			}
			else if(sel==2) {
	//			Shop();
			}
			else if(sel==3) {
	//			inven
			}
			else if(sel==4) {
				myGo.goketmonMenu();
			}
			else {
				
			}
		}
	} 

}
