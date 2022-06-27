package goketmonGame;

import java.util.Random;
import java.util.Scanner;

import stage.StageLobby;
import stage.StageMain;

public class GameManager {
	static Scanner sc=new Scanner(System.in);
	static Random ran=new Random();
	static int log=-1;
	private static boolean game=true;
	private StageMain sm=StageMain.getInstance();
	private StageLobby sl=StageLobby.getInstance();
	
	//로그인 각 메뉴
	//게임 진행
	
	public void run() {
			 this.sm.MainMenu();
	}

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		GameManager.sc = sc;
	}

	public static Random getRan() {
		return ran;
	}

	public static void setRan(Random ran) {
		GameManager.ran = ran;
	}

	public static int getLog() {
		return log;
	}

	public static void setLog(int log) {
		GameManager.log = log;
	}

	public static boolean isGame() {
		return game;
	}

	public static void setGame(boolean game) {
		GameManager.game = game;
	}
	
}
