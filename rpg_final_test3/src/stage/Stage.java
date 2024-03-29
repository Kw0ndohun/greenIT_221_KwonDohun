package stage;

import java.util.ArrayList;

import goketmonGame.GameManager;
import goketmonGame.Player;
import item.Item;
import item.ItemManager;
import unit.Unit;
import unit.UnitManager;

public class Stage {
	// 랜덤세팅된 몬스터리스트를 받는 어레이 리스트 필요
	static Stage instance = new Stage();
	private UnitManager um = UnitManager.getInstance();
	private ItemManager im = ItemManager.getInstance();
	private Player pl=Player.getInstance();
	private boolean run;

	public Stage() {
	}

	public void battle() {
		this.run = true;
		// 몬스터 세팅
		um.setMonForStage();
		// 몬스터 만났을 때 이펙트
		meetMonEffect();
		while (this.run) {
			printUnit();
			playerTurn();
			if (!run)
				break;
			monTurn();
			if (um.getMonList().isEmpty()) {
				System.out.println("승리!");
				break;
			}
			if (pl.getMyGoketmonInstance().getMyParty().isEmpty()) {
				System.out.println("패배.");
				break;
			}
		}
		um.getMonList().clear();
	}

	public void playerTurn() {
		ArrayList<Unit> al=pl.getMyGoketmonInstance().getMyParty();
		// 파티원 수만큼 턴 부여
		for (int n = 0; n < al.size(); n++) {
			if (!um.getMonList().isEmpty() && !al.isEmpty()) {
				System.out.println("=================[전투 메뉴]================");
				System.out.println("1.싸우다   2.가방 \n3.포켓몬   4.도망치다");

				int sel = GameManager.getSc().nextInt();
				if (sel == 1) {
					System.out.println("1.싸우다   2.가방 \n3.포켓몬   4.도망치다");
					int selSkill = GameManager.getSc().nextInt();
					
//					if() {
//						
//					}
					System.out.println("공격할 대상을 선택해주세요 : ");
					int selMon = GameManager.getSc().nextInt() - 1;
					if (selMon >= 0 && selMon < um.getMonList().size()) {
						al.get(n).attack(um.getMonList().get(selMon),al.get(n));
						checkDie();
					} else {
						System.out.println("잘못된 선택입니다.");
						n--;
						continue;
					}
				}
				else if (sel == 2) {
					Item temp = pl.getInvenInstance().selectUseItem();
					if (temp.getTarget() == 1) {
						printMyUnit();
						System.out.println("사용할 몬스터:");
						int useMonIdx = GameManager.getSc().nextInt() - 1;
						temp.effect(al.get(useMonIdx));
						pl.getInvenInstance().getInven().remove(temp);
						im.getItemList().remove(temp);
					} else {
						printMon();
						System.out.println("사용할 몬스터:");
						int useMonIdx = GameManager.getSc().nextInt() - 1;
						temp.effect(um.getMonList().get(useMonIdx));
						pl.getInvenInstance().getInven().remove(temp);
						im.getItemList().remove(temp);
					}
				} else if (sel == 3) {
					pl.getMyGoketmonInstance().changeParty();
				} else {
					int ranNum = GameManager.getRan().nextInt(10) + 1;
					if (ranNum > 3) {
						System.out.println(al.get(0).getName() + "는(은) 도망쳤다!");
						run = false;
						break;
					} else {
						System.out.println(al.get(0).getName() + "는(은) 도망칠 수 없다!");
					}
				}
			}
		}
		System.out.println();
	}

	public void monTurn() {
		ArrayList<Unit> al=pl.getMyGoketmonInstance().getMyParty();
		for (int n = 0; n < um.getMonList().size(); n++) {
			if (!um.getMonList().isEmpty() && !al.isEmpty()) {
				int ranIdx = GameManager.getRan().nextInt(al.size());
				um.getMonList().get(n).attack(al.get(ranIdx),um.getMonList().get(n));
				checkDie();
			}
		}
		System.out.println();
	}

	public void printUnit() {
		System.out.println("");
		System.out.println("=================[전투]================");
		printMyUnit();
		printMon();
	}

	public void printMyUnit() {
		System.out.println("=================[내 파티]================");
		for (int n = 0; n < pl.getMyGoketmonInstance().getMyParty().size(); n++) {
			System.out.print("[" + (n + 1) + "]");
			pl.getMyGoketmonInstance().getMyParty().get(n).print();
		}
	}

	public void printMon() {
		System.out.println("=================[몬스터]================");
		for (int n = 0; n < um.getMonList().size(); n++) {
			System.out.print("[" + (n + 1) + "]");
			um.getMonList().get(n).print();
		}
	}

	// 몬스터 만났을 때 이펙트
	public void meetMonEffect() {
		for (int n = 0; n < 4; n++) {
			if (n % 2 == 0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			} else {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			}
			try {
				Thread.sleep(250);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("");
		for (int n = 0; n < um.getMonList().size(); n++) {
			System.out.println("야생의 " + um.getMonList().get(n).getName() + "가 튀어나왔다!");
		}
		System.out.println("");
	}

	public void checkDie() {
		for (int n = 0; n < um.getMonList().size(); n++) {
			if (um.getMonList().get(n).getHp() == 0) {
				um.getMonList().remove(n);
				n--;
			}
		}
		for (int n = 0; n < pl.getMyGoketmonInstance().getMyParty().size(); n++) {
			if (pl.getMyGoketmonInstance().getMyParty().get(n).getHp() == 0) {
				pl.getMyGoketmonInstance().getMyParty().remove(n);
				n--;
			}
		}
	}

}
