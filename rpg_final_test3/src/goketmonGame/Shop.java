package goketmonGame;

import item.ItemManager;

public class Shop {
	//아이템매니저 아이템 리스트가져오기
	//몬스터볼 판매
	//회복아이템 
	static Shop instance=new Shop();
	//샵은 아이템 매니저를 사용하는게 맞음.
	private ItemManager im=ItemManager.getInstance();
	//샵에 플레이어가 와서 이용함.
	private Player pl=Player.instance;
	public void sellMenu() {
		while(true) {
			System.out.println("================[아이템 상점]===============");
			System.out.println("1.몬스터볼 : 500원");
			System.out.println("2.상처약 : 1000원");
			System.out.println("3.종료");
			System.out.println("구매할 아이템:");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				pl.getInvenInstance().getInven().add(im.addMonsterBall());
				System.out.println("구입완료.");
			}
			else if(sel==2) {
				pl.getInvenInstance().getInven().add(im.addPotion());
				System.out.println("구입완료.");
			}
			else {
				break;
			}
		}
	}
	public static Shop getInstance() {
		return instance;
	}
	public static void setInstance(Shop instance) {
		Shop.instance = instance;
	}
	
	
}
