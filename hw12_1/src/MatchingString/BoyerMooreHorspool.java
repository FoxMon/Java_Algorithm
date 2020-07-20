package MatchingString;

// BoyerMooreHorspool.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-06-19
// ���̾� ���� ȣ��Ǯ �˰����� ���� ���ڿ��� ��Ī���Ѻ���.

public class BoyerMooreHorspool {
	public void computeJump(String pattern, String text) { // Ž�� ����
		int patternLen = pattern.length(); // ������ ����
		int textLen = text.length(); // �ؽ�Ʈ�� ����
		int[] jump = new int[Character.MAX_VALUE + 1]; // ��� ���ڸ� �޴´ٰ� ����
		char[] patArr; // ����
		char[] textArr; // ����
		int point;
		
		patArr = pattern.toCharArray();
		textArr = text.toCharArray();
		
		// ���̺� ����
		for(int i = 0; i < jump.length; i++) {
			jump[i] = patArr.length; // ��Ÿ�� �ش��ϴ� ���̺��� ���� ū ������...
		}
		
		for(int i = 0; i < pattern.length() - 1; i++) {
			jump[patArr[i]] = patArr.length - 1 - i; // ���̺� ����
		}
		
		int i, j;
		i = j = 0;
		int count = 0; // ���� �� ���
		
		System.out.print("��Ī ��ġ = ");
		
		while( (i + patArr.length) <= (textArr.length) ) { // �ؽ�Ʈ�� ���̸� �����ϸ� ��
			j = patArr.length - 1; // ���� ���ڿ��� ���κп� �ش� tiger�� ��� r�� �ε���
			
			while( textArr[i + j] == patArr[j] ) { // ������ �޺κк��� ����
				j--;

				if(j < 0) { // �� ��ġ�ϸ� i�� ������ ��Ī�� �Ͼ ����
					point = i;
					System.out.print(point + " ");
					break;
				}	
			}
			
			int index = textArr[i + patArr.length - 1]; 
			i = i + jump[index]; // �����ϴ� ��
			count++;
		}
		System.out.println();
		System.out.println("���� ��  = " + count);
	}
}
