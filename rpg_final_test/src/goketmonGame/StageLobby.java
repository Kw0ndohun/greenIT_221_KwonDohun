package goketmonGame;

public class StageLobby {
	static StageLobby instance=new StageLobby();
	private MyGoketmon myGo=MyGoketmon.instance;
	
	public void lobbyMenu(){
		while(true) {
			
			System.out.println("==================Lobby================");
			System.out.println(" 1.��� 2.���� 3.�κ��丮 4.���ϸ� 5.���� ");
			System.out.println(" : ");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				Stage.instance.battle();
			}
			else if(sel==2) {
				Shop.instance.sellMenu();
			}
			else if(sel==3) {
				Inventory.instance.invenMenu();
			}
			else if(sel==4) {
				myGo.goketmonMenu();
			}
			else {
				GameManager.game=false;
				break;
			}
		}
	} 

}
