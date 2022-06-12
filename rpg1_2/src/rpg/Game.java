package rpg;

import java.util.Random;
import java.util.Scanner;


public class Game {
	//1.길드관리 2.상점 3. 인벤토리 4. 저장 5.로드
	//1. 길드유닛 필요/ 길드리스트>유닛으로 구성,파티리스트?>유닛으로 구성
	//ㄴ 유닛은 한 캐릭터
	//1.길드 캐릭터의 스텟출력/캐릭터(유닛)구매(길드원추가)/ 길드원 제거
	
	static Scanner scan=new Scanner(System.in);
	static Random ran=new Random();
	
	public Game() {
		Player player=new Player();
		Shop shop=new Shop();
		FileData fileData=new FileData();
		while(true) {
			System.out.println("----------[메인메뉴]---------");
			System.out.println("1.길드관리 2.상점 3.인벤토리");
			System.out.println("4.저장 5.로드 0.종료");
			int sel =scan.nextInt();
			if (sel==1) {
				Guild.gl.guildMenu();
			}
			else if(sel==2) {
				Shop.shop.shopMenu();
			}
			else if(sel==3) {
				Inventory.inven.invenMenu();
			}
			else if(sel==4) {
				//저장
				System.out.println("[데이터 저장]");
			}
			else if(sel==5) {
				//로드
				System.out.println("[데이터 로드]");
			}
			else if(sel==0) {
				System.out.println("[게임종료]");
				break;
			}
		}
	}

}
