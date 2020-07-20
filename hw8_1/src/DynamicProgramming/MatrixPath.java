package DynamicProgramming;

import java.util.Scanner;

// MatrixPath.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-22
// 동적프로그래밍을 통해 행렬의 경로를 찾아보도록 하자.

public class MatrixPath { // 행렬경로 클래스
	private int size; // 초기 배열 크기
	private int matrix[][]; // 초기 배열
	private int newMatrix[][]; // 새로운 배열
	private String maxPath; // 최대 경로
	
	public MatrixPath(int size) { // 생성자 오버로딩
		this.maxPath = "";
		this.size = size;
		matrix = new int[size][size];
		newMatrix = new int[size + 1][size + 1];
	}
	
	public String getMaxPath() { return maxPath; } // 경로 출력
	private boolean compare(int comp1, int comp2) { return (comp1 >= comp2); } // 두 원소 비교
	
	public int maxSum() { // 최대 경로 및 최대 경로의 합을 구함
		newMatrix = path(this.size); // 배열을 반환받고
		int i = 1;
		int j = 1;
		
		while(true) { // 최대 경로를 구함
			if(compare(newMatrix[i][j+1], newMatrix[i+1][j])) { // 우측 이동
				maxPath += "(" + i + ", " + j + ")";
				j++;
			} else { // 하단 이동
				maxPath += "(" + i + ", " + j + ")";
	            i++;
	        }
			
			if(i == size || j == size) { // 배열의 끝에 도달한 경우
				maxPath += "(" + i + ", " + j + ")";
				break; // 루프 탈출
			}
		}
		
		while(i != size) { // 남은 경로 계산
			i++;
			maxPath += "(" + i + ", " + j + ")";
		}
		
		while(j != size) { // 남은 경로 계산
			j++;
			maxPath += "(" + i + ", " + j + ")";
		}
		
		return newMatrix[size][size]; // 최대 경로의 합을 반환함
	}
	
	public void setMatrix() { // 행렬 원소 설정
		System.out.println(this.size + " x " + this.size + " 크기의 행렬 원소 입력 : ");
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
	}
	
	private int[][] path(int size) { // 경로를 구함
		int newSize = size + 1; // 새로운 배열의 크기
		int tempMatrix[][] = new int[newSize][newSize];
		int num;
		
		for(int i = 0; i < newSize; i++) { // 첫 번째 열을 0으로 초기화
			tempMatrix[i][0] = 0;
		}
		
		for(int j = 0; j < newSize; j++) { // 첫 번째 행을 0으로 초기화
			tempMatrix[0][j] = 0;
		}
		
		for(int i = 1; i < newSize; i++) { // 최소 경로를 구해서 임시 배열에 저장함
			for(int j = 1; j < newSize; j++) {
				if(compare(tempMatrix[i - 1][j], tempMatrix[i][j - 1])) { // 더 큰 값을 더함
					num = tempMatrix[i - 1][j];
				} else {
					num = tempMatrix[i][j - 1];
				}
				tempMatrix[i][j] = matrix[i - 1][j - 1] + num;
			}
		}
		
		return tempMatrix; // 새로운 값이 저장된 배열 반환
	}
}
