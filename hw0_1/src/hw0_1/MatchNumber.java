package hw0_1;

import java.util.Scanner;
	
public class MatchNumber { // 숫자 맞추기
	public static void main(String[] args) {
		int[] numArr = new int[] { -30, -15, 1, 40, 50, 200, 315, 800, 9000, 12345 }; // 오름차순으로 정렬된 정수를 저장한 배열 numArr
		Scanner scan = new Scanner(System.in); // 숫자를 입력받기 위한 Scanner객체 scan 생성
			
		System.out.println("hw0_1 : 김준호"); // 과제물 1번
		System.out.println("숫자 맞추기 프로그램입니다.");
		System.out.print("하나의 정수값을 입력하세요 : ");
			
		int userInput = scan.nextInt(); // 입력받은 정수값을 int형 변수에 저장
		int[] min = new int[10]; // 유저의 데이터와 배열의 데이터의 차를 저장할 배열
		int subMin; // 차의 최솟값을 저장하는 변수
		int res; // 결과값 ( 점수 ) 을 저장할 변수
			
		for(int i = 0; i < numArr.length; i++) { // 입력값과 데이터의 차를 계산하여 min 배열에 저장
			min[i] = userInput - numArr[i];
		}
			
		subMin = Math.abs(min[0]); // 첫번째 인덱스의 절대값을 기준으로 잡음
			
		for(int i = 1; i < min.length; i++) { // 기준인 subMin과의 대조를 위해 반복문 실행
			if(subMin >= Math.abs(min[i])) { // subMin보다 작은 값을 찾아서 subMin을 초기화해줌
				subMin = Math.abs(min[i]); // 입력값과 데이터의 차의 절대값이 작은 것으로 계속해서 초기화
			}
		}	
			
		res = (100 - subMin); // subMin값을 100에서 빼줌
			
		if(res >= 100 || res < 0) { // 차이가 100이상이거나 0이하의 경우에는 0으로 초기화
			res = 0; // 0을 저장
		}
			
		System.out.println("점수 = " + res); // 결과 출력
	}
}
