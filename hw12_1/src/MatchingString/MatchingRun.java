package MatchingString;

import java.util.Scanner;

// MatchingRun.java
// 201635006 컴퓨터공학과 김준호
// 2020-06-19
// 보이어 무어 호스풀 알고리즘을 통해 문자열을 매칭을 테스트해보자

public class MatchingRun { // 보이어 무어 호스풀 테스트
	public static void main(String[] args) {
		System.out.println("hw12_1: 김준호");
		
		Scanner userInput = new Scanner(System.in); 
		String text; // 문자열
		String pattern; // 패턴
		int count = 0;
		
		System.out.print("패턴 입력 : ");
		pattern = userInput.next();
		System.out.print("텍스트 입력 : ");
		text = userInput.next();
		
		BoyerMooreHorspool horspool = new BoyerMooreHorspool(); // 보이어-무어-호스풀 객체 생성
		horspool.computeJump(pattern, text);
	}
}
