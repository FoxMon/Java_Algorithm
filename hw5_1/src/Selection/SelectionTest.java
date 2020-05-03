package Selection;
import java.util.Scanner;

// SelectionTest.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-17
// 평균 선형 시간 선택 알고리즘을 수행하는 클래스의 기능을 테스트해보자

public class SelectionTest { // 선택 알고리즘 테스트
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // 유저 입력 객체
		
		System.out.println("hw5_1 : 김준호");
		
		System.out.print("정수갯수 입력 : ");
		int total = userInput.nextInt();
		
		int ranArr[] = new int[total]; // 입력받은 갯수의 int 배열 생성
		
		System.out.print(total + "개의 정수 입력 : ");
		
		for(int i = 0; i < total; i++) { // 15개의 정수 입력받음
			ranArr[i] = userInput.nextInt();
		}
		
		int target; // 찾으려는 인덱스
		
		if(total % 2 == 1) { // 홀수의 경우
			target = (total / 2) + 1;
		} else { // 짝수의 경우
			target = total / 2;
		}
		
		int middleNum = Selection.select(ranArr, 0, total - 1, target); // 배열 원소의 가운데 인덱스 구함
		System.out.println("중앙값 : " + middleNum); // 중앙값 출력
	}
}
