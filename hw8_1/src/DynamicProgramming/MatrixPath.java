package DynamicProgramming;

import java.util.Scanner;

// MatrixPath.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-05-22
// �������α׷����� ���� ����� ��θ� ã�ƺ����� ����.

public class MatrixPath { // ��İ�� Ŭ����
	private int size; // �ʱ� �迭 ũ��
	private int matrix[][]; // �ʱ� �迭
	private int newMatrix[][]; // ���ο� �迭
	private String maxPath; // �ִ� ���
	
	public MatrixPath(int size) { // ������ �����ε�
		this.maxPath = "";
		this.size = size;
		matrix = new int[size][size];
		newMatrix = new int[size + 1][size + 1];
	}
	
	public String getMaxPath() { return maxPath; } // ��� ���
	private boolean compare(int comp1, int comp2) { return (comp1 >= comp2); } // �� ���� ��
	
	public int maxSum() { // �ִ� ��� �� �ִ� ����� ���� ����
		newMatrix = path(this.size); // �迭�� ��ȯ�ް�
		int i = 1;
		int j = 1;
		
		while(true) { // �ִ� ��θ� ����
			if(compare(newMatrix[i][j+1], newMatrix[i+1][j])) { // ���� �̵�
				maxPath += "(" + i + ", " + j + ")";
				j++;
			} else { // �ϴ� �̵�
				maxPath += "(" + i + ", " + j + ")";
	            i++;
	        }
			
			if(i == size || j == size) { // �迭�� ���� ������ ���
				maxPath += "(" + i + ", " + j + ")";
				break; // ���� Ż��
			}
		}
		
		while(i != size) { // ���� ��� ���
			i++;
			maxPath += "(" + i + ", " + j + ")";
		}
		
		while(j != size) { // ���� ��� ���
			j++;
			maxPath += "(" + i + ", " + j + ")";
		}
		
		return newMatrix[size][size]; // �ִ� ����� ���� ��ȯ��
	}
	
	public void setMatrix() { // ��� ���� ����
		System.out.println(this.size + " x " + this.size + " ũ���� ��� ���� �Է� : ");
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
	}
	
	private int[][] path(int size) { // ��θ� ����
		int newSize = size + 1; // ���ο� �迭�� ũ��
		int tempMatrix[][] = new int[newSize][newSize];
		int num;
		
		for(int i = 0; i < newSize; i++) { // ù ��° ���� 0���� �ʱ�ȭ
			tempMatrix[i][0] = 0;
		}
		
		for(int j = 0; j < newSize; j++) { // ù ��° ���� 0���� �ʱ�ȭ
			tempMatrix[0][j] = 0;
		}
		
		for(int i = 1; i < newSize; i++) { // �ּ� ��θ� ���ؼ� �ӽ� �迭�� ������
			for(int j = 1; j < newSize; j++) {
				if(compare(tempMatrix[i - 1][j], tempMatrix[i][j - 1])) { // �� ū ���� ����
					num = tempMatrix[i - 1][j];
				} else {
					num = tempMatrix[i][j - 1];
				}
				tempMatrix[i][j] = matrix[i - 1][j - 1] + num;
			}
		}
		
		return tempMatrix; // ���ο� ���� ����� �迭 ��ȯ
	}
}
