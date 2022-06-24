package goketmonGame;

public class StageLobby {
	static StageLobby instance=new StageLobby();
	private MapManager mm=MapManager.instance;
	private Player pl=Player.instance;
	private int pX=0;
	private int pY=0;
	
	
	public void lobbyMenu(){
		while(true) {
			int xx=this.pX;
			int yy=this.pY;
			this.mm.printMap();
			System.out.println("==================[Lobby]================");
			System.out.println("       ==========[�̵�]==========");
			System.out.println("                   w");
			System.out.println("                 a s d");
			System.out.println("       =========================");
			System.out.println("    1.��� 2.���� 3.�κ��丮 4.���ϸ� 5.���� ");
			System.out.println(" : ");
			String sel=GameManager.sc.next();
			if(sel.equals("1")) {
				Stage.instance.battle();
			}
			else if(sel.equals("2")) {
				Shop.instance.sellMenu();
			}
			else if(sel.equals("3")) {
				pl.getInvenInstance().invenMenu();
			}
			else if(sel.equals("4")) {
				pl.getMyGoketmonInstance().goketmonMenu();
			}
			else if(sel.equals("w")) {
				yy++;
			}
			else if(sel.equals("s")) {
				yy--;
			}
			else if(sel.equals("a")) {
				xx--;
			}
			else if(sel.equals("d")) {
				xx++;
			}
			else {
				GameManager.game=false;
				break;
			}
		}
	} 
	
//	public void move() {
//		System.out.println("       ==========[�̵�]==========");
//		System.out.println("                   w");
//		System.out.println("                 a s d");
//		System.out.println("       =========================");
//	}
	
	public void moveCheck() {
		for(int n=0; n<mm.getMap().get(0).size(); n++) {
			
		}
		
		
	}
	

}
