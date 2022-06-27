package stage;

import goketmonGame.GameManager;
import goketmonGame.Player;
import goketmonGame.Shop;
import map.MapManager;

public class StageLobby {
	static StageLobby instance=new StageLobby();
	private MapManager mm=MapManager.getInstance();
	private Player pl=Player.getInstance();
	private int pX=0;
	private int pY=0;
	private int player=5;
	
	
	public StageLobby() {
		setPlayer();
	}
	
	public void lobbyMenu(){
		while(true) {
			int xx=this.pX;
			int yy=this.pY;
			this.mm.printMap();
			System.out.println("==================[Lobby]================");
			System.out.println("       ==========[이동]==========");
			System.out.println("                   w");
			System.out.println("                 a s d");
			System.out.println("       =========================");
			System.out.println("    1.상점 2.인벤토리 3.고켓몬 4.종료 ");
			System.out.println(" : ");
			String sel=GameManager.getSc().next();
			if(sel.equals("1")) {
				Shop.getInstance().sellMenu();
			}
			else if(sel.equals("2")) {
				pl.getInvenInstance().invenMenu();
			}
			else if(sel.equals("3")) {
				pl.getMyGoketmonInstance().goketmonMenu();
			}
			else if(sel.equals("4")) {
				GameManager.setGame(false);
				break;
			}
			else if(sel.equals("w")) {
				yy--;
			}
			else if(sel.equals("s")) {
				yy++;
			}
			else if(sel.equals("a")) {
				xx--;
			}
			else if(sel.equals("d")) {
				xx++;
			}
			else {
				System.out.println("잘못 입력");
			}
			
			if(moveCheck(xx,yy)) {
				System.out.println("맵의 끝이다");
				continue;
			}
			checkMon();
		}
	} 
	
//	public void move() {
//		System.out.println("       ==========[이동]==========");
//		System.out.println("                   w");
//		System.out.println("                 a s d");
//		System.out.println("       =========================");
//	}
	
	public boolean moveCheck(int xx,int yy) {
		System.out.println(mm.getMap().get(0).size());
		System.out.println(mm.getMap().size());
		if( xx<0 || mm.getMap().get(0).size()<=xx || yy<0 || yy >= mm.getMap().size()) {
			return true;
		}
		mm.getMap().get(this.pY).get(this.pX).setNum(0);
		mm.getMap().get(yy).get(xx).setNum(player);
		this.pY=yy;
		this.pX=xx;
//		for(int n=0; n<mm.getMap().size(); n++) {
//			for(int i=0; i<mm.getMap().get(0).size(); n++) {
//			}
//		}
		
		return false;
	}
	//최초 플레이어 위치
	public void setPlayer() {
		mm.getMap().get(this.pY).get(this.pX).setNum(player);
	}
	// 몬스터가 출현하는 맵인지 체크
	public void checkMon() {
		if(mm.getMap().get(this.pY).get(this.pX).isDangerMap()) {
			int monEmerge=GameManager.getRan().nextInt(10);
			if(monEmerge<5) {
				System.out.println("dd");
				Stage.instance.battle();
			}
		}
	}

	public static StageLobby getInstance() {
		return instance;
	}

	public static void setInstance(StageLobby instance) {
		StageLobby.instance = instance;
	}

}
