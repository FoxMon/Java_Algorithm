package MatchingString;

import java.util.Scanner;

// MatchingRun.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-06-19
// ���̾� ���� ȣ��Ǯ �˰����� ���� ���ڿ��� ��Ī�� �׽�Ʈ�غ���

public class MatchingRun { // ���̾� ���� ȣ��Ǯ �׽�Ʈ
	public static void main(String[] args) {
		System.out.println("hw12_1: ����ȣ");
		
		Scanner userInput = new Scanner(System.in); 
		String text; // ���ڿ�
		String pattern; // ����
		int count = 0;
		
		System.out.print("���� �Է� : ");
		pattern = userInput.next();
		System.out.print("�ؽ�Ʈ �Է� : ");
		text = userInput.next();
		
		BoyerMooreHorspool horspool = new BoyerMooreHorspool(); // ���̾�-����-ȣ��Ǯ ��ü ����
		horspool.computeJump(pattern, text);
	}
}
