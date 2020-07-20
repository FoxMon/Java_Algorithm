package DynamicProgramming;

// PebbleMain.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-27
// 동적프로그래밍을 이용한 조약돌 놓기의 기능을 테스트해보자.

public class PebbleMain {
	public static void main(String[] args) {
		Pebble peb = new Pebble();
		
		System.out.println("hw8_2 : 김준호");
		
		peb.pebble(); // 조약돌 행렬을 구함
		peb.print(); // 결과 행렬 출력
	}
}
