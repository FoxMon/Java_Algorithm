package DynamicProgramming;

// Pebble.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-05-27
// �������α׷����� ���� ���൹�� ���ƺ����� ����.

public class Pebble {
	private int peb[][] = new int[4][5]; // 4 x 5 pebble ��� ���
	private int table[][] = { // 3 x 5 ���
			{5, 3, -20, 10, 10},
			{2, 5, 10, 5, -5},
			{10, 6, 1, -10, 5}
	};
	public int pattern[][] = { // �縳�ϴ� ����
			{ 2, 3, 0 }, 
			{ 1, 3, 4 }, 
			{ 1, 2, 0 }, 
			{ 2, 0, 0 } 
	};
	
	private int maxPattern(int i, int p) { // ������ ���ϵ�.
		if(p == 1) {
			return table[0][i];
		} else if(p == 2) {
			return table[1][i];
		} else if(p == 3) {
			return table[2][i];
		} else if(p == 4) {
			return table[2][i] + table[0][i];
		} 
		
		return 0; // �� ���� ���� ����
	}
	
	private int max(int i, int p) { // �縳�ϴ� ���� �� �ִ�
		int temp;
		int max = -10000;
		
		for(int a = 0; a < 3; a++) {
			int index  = pattern[p][a];
			
			if(index == 0) { // ���� ��� �ݺ��� ���� ( ���� �տ��� �� �ɸ� )
				break;
			} else { // �ٷ� �� �� �߿��� �ִ��� ���� ã��
				temp = peb[index - 1][i];
				
				if(temp > max) { // ������ ���鼭 �ִ��� ��츦 ã��
					max = temp;
				}
			}
		}
		
		return max;
	}
	
	public void print() { // peb���̺� ���� ���
		int maxNum = peb[0][4];
		
		
		for(int i = 1; i < 4; i++) { // �ִ� ��
			if(maxNum < peb[i][4]) {
				maxNum = peb[i][4];
			}
		}
		
		for(int p = 0; p < 4; p++) { // ��� ���� ���
			for(int i = 0; i < 5; i++) {
				System.out.print(peb[p][i] + " ");
			}
			System.out.println();
		}
		
		System.out.println("�ִ� ���� = " + maxNum + " �Դϴ�.");
	}
	
	public void pebble() { // ���ϼ� �ִ� ���� �ְ� ����
		for(int p = 1; p < 5; p++) { // ù ���� �ʱ�ȭ
			peb[p - 1][0] = maxPattern(0, p);
		}
		
		for(int i = 1; i <= 4; i++) {
			for(int p = 0; p < 4; p++) {
				peb[p][i] = maxPattern(i, p + 1) + max(i - 1, p);
			}
		}
	}
}
