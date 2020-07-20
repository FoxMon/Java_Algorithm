package MatchingString;

// BoyerMooreHorspool.java
// 201635006 컴퓨터공학과 김준호
// 2020-06-19
// 보이어 무어 호스풀 알고리즘을 통해 문자열을 매칭시켜보자.

public class BoyerMooreHorspool {
	public void computeJump(String pattern, String text) { // 탐색 시작
		int patternLen = pattern.length(); // 패턴의 길이
		int textLen = text.length(); // 텍스트의 길이
		int[] jump = new int[Character.MAX_VALUE + 1]; // 모든 문자를 받는다고 가정
		char[] patArr; // 패턴
		char[] textArr; // 문자
		int point;
		
		patArr = pattern.toCharArray();
		textArr = text.toCharArray();
		
		// 테이블 구성
		for(int i = 0; i < jump.length; i++) {
			jump[i] = patArr.length; // 기타에 해당하는 테이블은 전부 큰 값으로...
		}
		
		for(int i = 0; i < pattern.length() - 1; i++) {
			jump[patArr[i]] = patArr.length - 1 - i; // 테이블 구성
		}
		
		int i, j;
		i = j = 0;
		int count = 0; // 점프 수 기록
		
		System.out.print("매칭 위치 = ");
		
		while( (i + patArr.length) <= (textArr.length) ) { // 텍스트의 길이를 오버하면 끝
			j = patArr.length - 1; // 패턴 문자열의 끝부분에 해당 tiger의 경우 r의 인덱스
			
			while( textArr[i + j] == patArr[j] ) { // 패턴의 뒷부분부터 비교함
				j--;

				if(j < 0) { // 다 일치하면 i의 값에서 매칭이 일어난 것임
					point = i;
					System.out.print(point + " ");
					break;
				}	
			}
			
			int index = textArr[i + patArr.length - 1]; 
			i = i + jump[index]; // 점프하는 값
			count++;
		}
		System.out.println();
		System.out.println("점프 수  = " + count);
	}
}
