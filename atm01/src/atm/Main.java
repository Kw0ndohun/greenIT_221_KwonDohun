package atm;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//ȸ�� �� ���, ���� �ִ� 3��
		// 1.ȸ������/Ż��
		//��User
		//UserManager (static)
		//2.���°���/����
		//��Account
		//��AccountManager (static)
		
		//3.atm �
		//�� Bank (static)
		
		Bank.setName("Green");
		Bank.instance.run();
	}
}
