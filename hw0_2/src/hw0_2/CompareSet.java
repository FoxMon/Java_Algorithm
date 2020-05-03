package hw0_2;

import java.util.Scanner;

public class CompareSet { // �� ���� ���� ������ ���ϴ� Ŭ����
	final static int SIZE = 100;
	
	public static void main(String[] args) {
		int setA[] = new int[SIZE]; // ���� A�� �迭 ����
		int setB[] = new int[SIZE]; // ���� B�� �迭 ����
		int sameCnt = 0; // ���� ������ ������ �����ֱ� ���� ���� sameCnt ����
		int idx = 0; // �迭�� �ε���
		Scanner userInput = new Scanner(System.in); // user�� �Է��� ���� Scanner ��ü ����
		
		System.out.println("hw0_2 : ����ȣ");
		System.out.println("���� ���� ������ ���ϴ� ���α׷��Դϴ�.");
		
		System.out.print( "ù��° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� ������ �Է��ϼ��� : ");
		
		while(true) {
			int setNum = userInput.nextInt(); // ����A�� ���Ҹ� �Է¹���
			
			if(setNum < 0) { // ���� �Է� �� �ݺ��� Ż��
				break;
			}
				
			setA[idx++] = setNum; // �ε����� ���� �÷��ָ鼭 �� �ε����� �Է¹��� ���� ����
				
			if(idx > (SIZE - 1)) { // �迭�� ������� ū ���� ��� ���� ��� �� ���� ����
				System.out.println("������ ������ 100���� �Ѿ����ϴ�.");
				return;
			}
		}
		
		System.out.print( "�ι�° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� ������ �Է��ϼ��� : ");
		
		idx = 0; // �迭�� ���ο� �����͸� ���� ���̱� ������ �ε����� 0���� �ٽ� �ʱ�ȭ
		
		while(true) {
			int setNum = userInput.nextInt(); // ����B�� ���Ҹ� �Է¹���
			
			if(setNum < 0) { // ���� �Է� �� �ݺ��� Ż��
				break;
			}
				
			setB[idx++] = setNum; // ���� �������, �ε����� ���� �÷��ָ鼭 �� �ε����� �Է¹��� ���� ����
				
			if(idx > (SIZE - 1)) { // �迭�� ������� ū ���� ��� ���� ��� �Ŀ� ���� �����Ѵ�
				System.out.println("������ ������ 100���� �Ѿ����ϴ�.");
				return;	
			}
		}
		
		if(setA.length != setB.length) { // �� ������ ����� �ٸ� ���� ���� �ٸ� �����̹Ƿ� ���� �ʴٰ� �Ǵ�
			System.out.println("�� ������ �ٸ��ϴ�.");
		}
		
		for(int i = 0; i < setA.length; i++) { // �� ������ ����
			for(int j = 0; j < setB.length; j++) {
				if(setA[i] == setB[j]) { // ������ ���� ���Ҹ� �ϳ��ϳ� ���Ͽ� ���ٸ�
					sameCnt++; // sameCnt�� ���� ���� �÷���
					break; // �ߺ��� ���Ұ� ���ٰ� �����ϹǷ�, ���� ���Ҹ� ã�� ��� �� ��° for�� Ż��
				}
			}
		}
		
		if(sameCnt == setA.length && sameCnt == setB.length) { // sameCnt�� �� ������ ũ��� ���ٸ� �� ������ ���� ����
			System.out.println("�� ������ �����ϴ�.");
		} else { // ī��Ʈ�� �ٸ��ٸ� �� ������ �ٸ� �����
			System.out.println("�� ������ �ٸ��ϴ�.");
		}
	}
}
