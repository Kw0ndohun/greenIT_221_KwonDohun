package goketmonGame;

import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static Scanner sc=new Scanner(System.in);
	static Random ran=new Random();
	static int log=-1;
	static boolean game=true;
	private StageMain sm=StageMain.instance;
	private StageLobby sl=StageLobby.instance;
	
	//로그인 각 메뉴
	//게임 진행
	
	public void run() {
			 this.sm.MainMenu();
//			 if(this.log!=-1) {
//				 this.sl.lobbyMenu();
//			 }
	}
}
