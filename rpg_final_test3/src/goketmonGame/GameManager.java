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
	
	//�α��� �� �޴�
	//���� ����
	
	public void run() {
			 this.sm.MainMenu();
//			 if(this.log!=-1) {
//				 this.sl.lobbyMenu();
//			 }
	}
}
