package goketmonGame;

public class StageLobby {
	static StageLobby instance=new StageLobby();
	private MyGoketmon myGo=MyGoketmon.instance;
	
	public void lobbyMenu(){
		while(true) {
			
			System.out.println("===========Lobby===========");
			System.out.println(" 1.사냥 2.상점 3.인벤토리 4.내 고켓몬 5.종료 ");
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
