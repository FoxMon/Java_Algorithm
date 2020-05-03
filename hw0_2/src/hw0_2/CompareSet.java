package hw0_2;

import java.util.Scanner;

public class CompareSet { // 두 양의 정수 집합을 비교하는 클래스
	final static int SIZE = 100;
	
	public static void main(String[] args) {
		int setA[] = new int[SIZE]; // 집합 A의 배열 생성
		int setB[] = new int[SIZE]; // 집합 B의 배열 생성
		int sameCnt = 0; // 같은 원소의 갯수를 세어주기 위한 변수 sameCnt 선언
		int idx = 0; // 배열의 인덱스
		Scanner userInput = new Scanner(System.in); // user의 입력을 받을 Scanner 객체 생성
		
		System.out.println("hw0_2 : 김준호");
		System.out.println("양의 정수 집합을 비교하는 프로그램입니다.");
		
		System.out.print( "첫번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요 : ");
		
		while(true) {
			int setNum = userInput.nextInt(); // 집합A의 원소를 입력받음
			
			if(setNum < 0) { // 음수 입력 시 반복문 탈출
				break;
			}
				
			setA[idx++] = setNum; // 인덱스의 값을 늘려주면서 각 인덱스에 입력받은 정수 저장
				
			if(idx > (SIZE - 1)) { // 배열의 사이즈보다 큰 값일 경우 에러 출력 후 강제 종료
				System.out.println("원소의 갯수가 100개가 넘었습니다.");
				return;
			}
		}
		
		System.out.print( "두번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요 : ");
		
		idx = 0; // 배열에 새로운 데이터를 넣을 것이기 때문에 인덱스를 0으로 다시 초기화
		
		while(true) {
			int setNum = userInput.nextInt(); // 집합B의 원소를 입력받음
			
			if(setNum < 0) { // 음수 입력 시 반복문 탈출
				break;
			}
				
			setB[idx++] = setNum; // 같은 방식으로, 인덱스의 값을 늘려주면서 각 인덱스에 입력받은 정수 저장
				
			if(idx > (SIZE - 1)) { // 배열의 사이즈보다 큰 값일 경우 에러 출력 후에 강제 종료한다
				System.out.println("원소의 갯수가 100개가 넘었습니다.");
				return;	
			}
		}
		
		if(setA.length != setB.length) { // 두 집합의 사이즈가 다른 경우는 서로 다른 집합이므로 같지 않다고 판단
			System.out.println("두 집합은 다릅니다.");
		}
		
		for(int i = 0; i < setA.length; i++) { // 두 집합을 비교함
			for(int j = 0; j < setB.length; j++) {
				if(setA[i] == setB[j]) { // 각각의 집합 원소를 하나하나 비교하여 같다면
					sameCnt++; // sameCnt의 변수 값을 늘려줌
					break; // 중복된 원소가 없다고 가정하므로, 같은 원소를 찾는 즉시 두 번째 for문 탈출
				}
			}
		}
		
		if(sameCnt == setA.length && sameCnt == setB.length) { // sameCnt가 두 집합의 크기와 같다면 두 집합은 같은 것임
			System.out.println("두 집합은 같습니다.");
		} else { // 카운트가 다르다면 두 집합은 다른 경우임
			System.out.println("두 집합은 다릅니다.");
		}
	}
}
