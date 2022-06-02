package atm;

import java.util.Scanner;

public class Bank {
	public static Bank instance=new Bank();
	public static Scanner sc=new Scanner(System.in);
	private static String name;
	
	public String getName() {
		return name;
	}
	public static void setName(String name2) {
		name = name2;
	}
	private Bank(){
		
	}
	public void run() {
		//½ÇÇà
	}
	
}
