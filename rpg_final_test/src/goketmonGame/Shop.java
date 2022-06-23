package goketmonGame;

public class Shop {
	//아이템매니저 아이템 리스트가져오기
	//몬스터볼 판매
	//회복아이템 
	static Shop instance=new Shop();
	private ItemManager im=ItemManager.instance;
	private Inventory it=Inventory.instance;
	public void sellMenu() {
		while(true) {
			System.out.println("================[아이템 상점]===============");
			System.out.println("1.몬스터볼 : 500원");
			System.out.println("2.상처약 : 1000원");
			System.out.println("3.종료");
			System.out.println("구매할 아이템:");
			int sel=GameManager.sc.nextInt();
			if(sel==1) {
				it.getInven().add(im.addMonsterBall());
				System.out.println("구입완료.");
			}
			else if(sel==2) {
				it.getInven().add(im.addPotion());
				System.out.println("구입완료.");
			}
			else {
				break;
			}
		}
	}
	
	
}
