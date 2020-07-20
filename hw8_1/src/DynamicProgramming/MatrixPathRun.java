package DynamicProgramming;

import java.util.Scanner;

// MatrixPathRun.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-05-22
// �������α׷����� ���� ����� ��θ� ã�ƺ��°��� ����ؼ� Ȯ���� ������ ����.

public class MatrixPathRun {
	public static void main(String[] args) {
		System.out.println("hw8_1 : ����ȣ");
		Scanner userInput = new Scanner(System.in);
		System.out.print("���� ũ�� �Է� : "); // ũ�� ����
		
		int size = userInput.nextInt();
		MatrixPath path = new MatrixPath(size); // ��� ��ü ����
		
		path.setMatrix(); // ����� ���� �Է�

		System.out.println("�ְ� ���� = " + path.maxSum()); // �ִ� ���� ���
		System.out.println("�ִ� ���� ��� = " + path.getMaxPath());
	}
}
