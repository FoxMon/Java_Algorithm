package hw0_1;

import java.util.Scanner;
	
public class MatchNumber { // ���� ���߱�
	public static void main(String[] args) {
		int[] numArr = new int[] { -30, -15, 1, 40, 50, 200, 315, 800, 9000, 12345 }; // ������������ ���ĵ� ������ ������ �迭 numArr
		Scanner scan = new Scanner(System.in); // ���ڸ� �Է¹ޱ� ���� Scanner��ü scan ����
			
		System.out.println("hw0_1 : ����ȣ"); // ������ 1��
		System.out.println("���� ���߱� ���α׷��Դϴ�.");
		System.out.print("�ϳ��� �������� �Է��ϼ��� : ");
			
		int userInput = scan.nextInt(); // �Է¹��� �������� int�� ������ ����
		int[] min = new int[10]; // ������ �����Ϳ� �迭�� �������� ���� ������ �迭
		int subMin; // ���� �ּڰ��� �����ϴ� ����
		int res; // ����� ( ���� ) �� ������ ����
			
		for(int i = 0; i < numArr.length; i++) { // �Է°��� �������� ���� ����Ͽ� min �迭�� ����
			min[i] = userInput - numArr[i];
		}
			
		subMin = Math.abs(min[0]); // ù��° �ε����� ���밪�� �������� ����
			
		for(int i = 1; i < min.length; i++) { // ������ subMin���� ������ ���� �ݺ��� ����
			if(subMin >= Math.abs(min[i])) { // subMin���� ���� ���� ã�Ƽ� subMin�� �ʱ�ȭ����
				subMin = Math.abs(min[i]); // �Է°��� �������� ���� ���밪�� ���� ������ ����ؼ� �ʱ�ȭ
			}
		}	
			
		res = (100 - subMin); // subMin���� 100���� ����
			
		if(res >= 100 || res < 0) { // ���̰� 100�̻��̰ų� 0������ ��쿡�� 0���� �ʱ�ȭ
			res = 0; // 0�� ����
		}
			
		System.out.println("���� = " + res); // ��� ���
	}
}
