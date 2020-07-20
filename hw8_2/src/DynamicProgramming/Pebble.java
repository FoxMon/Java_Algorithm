package DynamicProgramming;

// Pebble.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-27
// 동적프로그래밍을 통해 조약돌을 놓아보도록 하자.

public class Pebble {
	private int peb[][] = new int[4][5]; // 4 x 5 pebble 행렬 결과
	private int table[][] = { // 3 x 5 행렬
			{5, 3, -20, 10, 10},
			{2, 5, 10, 5, -5},
			{10, 6, 1, -10, 5}
	};
	public int pattern[][] = { // 양립하는 패턴
			{ 2, 3, 0 }, 
			{ 1, 3, 4 }, 
			{ 1, 2, 0 }, 
			{ 2, 0, 0 } 
	};
	
	private int maxPattern(int i, int p) { // 각각의 패턴들.
		if(p == 1) {
			return table[0][i];
		} else if(p == 2) {
			return table[1][i];
		} else if(p == 3) {
			return table[2][i];
		} else if(p == 4) {
			return table[2][i] + table[0][i];
		} 
		
		return 0; // 그 외의 경우는 없음
	}
	
	private int max(int i, int p) { // 양립하는 패턴 중 최대
		int temp;
		int max = -10000;
		
		for(int a = 0; a < 3; a++) {
			int index  = pattern[p][a];
			
			if(index == 0) { // 없을 경우 반복문 종료 ( 보통 앞에서 다 걸림 )
				break;
			} else { // 바로 전 열 중에서 최대의 패턴 찾음
				temp = peb[index - 1][i];
				
				if(temp > max) { // 패턴을 돌면서 최대의 경우를 찾음
					max = temp;
				}
			}
		}
		
		return max;
	}
	
	public void print() { // peb테이블 정보 출력
		int maxNum = peb[0][4];
		
		
		for(int i = 1; i < 4; i++) { // 최대 값
			if(maxNum < peb[i][4]) {
				maxNum = peb[i][4];
			}
		}
		
		for(int p = 0; p < 4; p++) { // 모든 정보 출력
			for(int i = 0; i < 5; i++) {
				System.out.print(peb[p][i] + " ");
			}
			System.out.println();
		}
		
		System.out.println("최대 값은 = " + maxNum + " 입니다.");
	}
	
	public void pebble() { // 놓일수 있는 돌의 최고 점수
		for(int p = 1; p < 5; p++) { // 첫 열을 초기화
			peb[p - 1][0] = maxPattern(0, p);
		}
		
		for(int i = 1; i <= 4; i++) {
			for(int p = 0; p < 4; p++) {
				peb[p][i] = maxPattern(i, p + 1) + max(i - 1, p);
			}
		}
	}
}
