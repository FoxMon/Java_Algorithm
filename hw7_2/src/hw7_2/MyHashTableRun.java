package hw7_2;

import java.util.Scanner;

// MyHashTableRun.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-09
// 해시테이블 체이닝 방식으로 구현한 클래스의 기능을 테스트해보도록 하자.

public class MyHashTableRun { // HashTable 기능 테스트
	public static void main(String[] args) {
		System.out.println("hw7_2 : 김준호");
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("해시테이블 크기 입력 : ");
		int size = userInput.nextInt();
		MyHashTable myHash = new MyHashTable(size); // 해시테이블 생성
		int stuID, mode, score;
		
		while(true) { // menu
			System.out.print("1:삽입 2:검색 3:삭제 4:테이블출력 5:종료 ---> ");
			mode = userInput.nextInt();
			
			switch(mode) {
			case 1: // 삽입
				System.out.print("삽입할 학번, 성적(정수값)을 입력하세요:");
				stuID = userInput.nextInt();
				score = userInput.nextInt();
				
				if(myHash.put(stuID, score)) { // 삽입성공
					System.out.println(stuID + ", " + score + " 삽입 성공");
				} else { // 삽입실패
					System.out.println("삽입 실패");
				}
				break;
				
			case 2: // 검색
				System.out.print("검색할 학번을 입력하세요:");
				stuID = userInput.nextInt();
				
				if(myHash.get(stuID) != -1) { // 탐색성공
					System.out.println(stuID + "번 학생의 성적은 " + myHash.get(stuID) + "입니다.");
				} else { // 탐색실패
					System.out.println("학생을 찾지 못했습니다.");
				}
				break;
				
			case 3: // 삭제
				System.out.print("삭제할 학번(정수값)을 입력하세요:");
				stuID = userInput.nextInt();
				
				if(myHash.remove(stuID)) { // 삭제성공
					System.out.println(stuID + "삭제 성공");
				} else { // 삭제실패
					System.out.println("삭제 실패");
				}
				break;
				
			case 4: // 출력
				myHash.print();
				break;
				
			case 5: // 종료
				System.out.println("프로그랩을 종료합니다.");
				return;
			}
		}
	}
}
