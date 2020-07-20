package DynamicProgramming;

import java.util.Scanner;

// MatrixPathRun.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-22
// 동적프로그래밍을 통해 행렬의 경로를 찾아보는것을 출력해서 확인해 보도록 하자.

public class MatrixPathRun {
	public static void main(String[] args) {
		System.out.println("hw8_1 : 김준호");
		Scanner userInput = new Scanner(System.in);
		System.out.print("행의 크기 입력 : "); // 크기 설정
		
		int size = userInput.nextInt();
		MatrixPath path = new MatrixPath(size); // 행렬 객체 생성
		
		path.setMatrix(); // 행렬의 원소 입력

		System.out.println("최고 점수 = " + path.maxSum()); // 최대 점수 출력
		System.out.println("최대 점수 경로 = " + path.getMaxPath());
	}
}
