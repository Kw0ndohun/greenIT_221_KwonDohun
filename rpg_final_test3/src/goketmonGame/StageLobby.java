package goketmonGame;

public class StageLobby {
	static StageLobby instance=new StageLobby();
	private MapManager mm=MapManager.instance;
	private Player pl=Player.instance;
	
	public void lobbyMenu(){
		while(true) {
			mm.printMap();
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
				pl.getInvenInstance().invenMenu();
			}
			else if(sel==4) {
				pl.getMyGoketmonInstance().goketmonMenu();
			}
			else {
				GameManager.game=false;
				break;
			}
		}
	} 

}
