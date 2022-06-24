package goketmonGame;

public class Stage {
	// �������õ� ���͸���Ʈ�� �޴� ��� ����Ʈ �ʿ�
	static Stage instance = new Stage();
	private UnitManager um = UnitManager.instance;
	private ItemManager im = ItemManager.instance;
	private Player pl=Player.instance;
	private boolean run;

	public Stage() {
	}

	public void battle() {
		this.run = true;
		// ���� ����
		um.setMonForStage();
		// ���� ������ �� ����Ʈ
		meetMonEffect();
		while (this.run) {
			printUnit();
			playerTurn();
			if (!run)
				break;
			monTurn();
			if (um.getMonList().isEmpty()) {
				System.out.println("�¸�!");
				break;
			}
			if (pl.getMyGoketmonInstance().getMyParty().isEmpty()) {
				System.out.println("�й�.");
				break;
			}
		}
		um.getMonList().clear();
	}

	public void playerTurn() {
		// ��Ƽ�� ����ŭ �� �ο�
		for (int n = 0; n < pl.getMyGoketmonInstance().getMyParty().size(); n++) {
			if (!um.getMonList().isEmpty() && !pl.getMyGoketmonInstance().getMyParty().isEmpty()) {
				System.out.println("=================[���� �޴�]================");
				System.out.println("1.�ο��   2.���� \n3.���ϸ�   4.����ġ��");

				int sel = GameManager.sc.nextInt();
				if (sel == 1) {
					System.out.println("������ ����� �������ּ��� : ");
					int selMon = GameManager.sc.nextInt() - 1;
					if (selMon >= 0 && selMon < um.getMonList().size()) {
						pl.getMyGoketmonInstance().getMyParty().get(n).attack(um.getMonList().get(selMon),pl.getMyGoketmonInstance().getMyParty().get(n));
						checkDie();
					} else {
						System.out.println("�߸��� �����Դϴ�.");
						n--;
						continue;
					}
				}

				else if (sel == 2) {
					Item temp = pl.getInvenInstance().selectUseItem();
					if (temp.getTarget() == 1) {
						printMyUnit();
						System.out.println("����� ����:");
						int useMonIdx = GameManager.sc.nextInt() - 1;
						temp.effect(pl.getMyGoketmonInstance().getMyParty().get(useMonIdx));
						pl.getInvenInstance().getInven().remove(temp);
						im.getItemList().remove(temp);
					} else {
						printMon();
						System.out.println("����� ����:");
						int useMonIdx = GameManager.sc.nextInt() - 1;
						temp.effect(um.getMonList().get(useMonIdx));
						pl.getInvenInstance().getInven().remove(temp);
						im.getItemList().remove(temp);
					}
				} else if (sel == 3) {
					pl.getMyGoketmonInstance().changeParty();
				} else {
					int ranNum = GameManager.ran.nextInt(10) + 1;
					if (ranNum > 3) {
						System.out.println(pl.getMyGoketmonInstance().getMyParty().get(0).getName() + "��(��) �����ƴ�!");
						run = false;
						break;
					} else {
						System.out.println(pl.getMyGoketmonInstance().getMyParty().get(0).getName() + "��(��) ����ĥ �� ����!");
					}
				}
			}
		}
		System.out.println();
	}

	public void monTurn() {
		for (int n = 0; n < um.getMonList().size(); n++) {
			if (!um.getMonList().isEmpty() && !pl.getMyGoketmonInstance().getMyParty().isEmpty()) {
				int ranIdx = GameManager.ran.nextInt(pl.getMyGoketmonInstance().getMyParty().size());
				um.getMonList().get(n).attack(pl.getMyGoketmonInstance().getMyParty().get(ranIdx),um.getMonList().get(n));
				checkDie();
			}
		}
		System.out.println();
	}

	public void printUnit() {
		System.out.println("");
		System.out.println("=================[����]================");
		printMyUnit();
		printMon();
	}

	public void printMyUnit() {
		System.out.println("=================[�� ��Ƽ]================");
		for (int n = 0; n < pl.getMyGoketmonInstance().getMyParty().size(); n++) {
			System.out.print("[" + (n + 1) + "]");
			pl.getMyGoketmonInstance().getMyParty().get(n).print();
		}
	}

	public void printMon() {
		System.out.println("=================[����]================");
		for (int n = 0; n < um.getMonList().size(); n++) {
			System.out.print("[" + (n + 1) + "]");
			um.getMonList().get(n).print();
		}
	}

	// ���� ������ �� ����Ʈ
	public void meetMonEffect() {
		for (int n = 0; n < 4; n++) {
			if (n % 2 == 0) {
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
				System.out.println("���������������������������������������");
			} else {
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
		System.out.println("");
		for (int n = 0; n < um.getMonList().size(); n++) {
			System.out.println("�߻��� " + um.getMonList().get(n).getName() + "�� Ƣ��Դ�!");
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
