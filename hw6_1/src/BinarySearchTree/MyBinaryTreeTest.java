package BinarySearchTree;
import java.util.Scanner;

// MyBinaryTreeTest.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-21
// 이진탐색트리 Class 기능을 시험해보자

public class MyBinaryTreeTest {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(); // 비어있는 트리객체
		Scanner userInput = new Scanner(System.in);
		String inputId;
		int select;
		
		System.out.println("hw6_1 : 김준호");
		
		while(true) {
			System.out.println("1:삽입 2:검색 3:삭제 4:전체조회 5:종료");
			select = userInput.nextInt(); // 메뉴 선택
			
			switch(select) {
			case 1: // 삽입 수행
				System.out.print("삽입할 아이디를 입력하세요 : ");
				inputId = userInput.next();
				
				if(tree.add(inputId)) {
					System.out.println(inputId + " 가 정상적으로 삽입됐습니다.");
				} else {
					System.out.println(inputId + " 가 정상적으로 삽입되지 못했습니다.");
				}
				
				break;
			case 2: // 검색 수행
				System.out.print("검색할 아이디를 입력하세요 : ");
				inputId = userInput.next();
				if(tree.contains(inputId)) {
					System.out.println(inputId + "는 존재하는 ID입니다.");
				} else {
					System.out.println(inputId + "는 존재하지 않는 ID입니다.");
				}
				break;
			case 3: // 삭제 수행
				System.out.print("삭제할 아이디를 입력하세요 : ");
				inputId = userInput.next();
				
				if(tree.remove(inputId)) {
					System.out.println(inputId + " 가 정상적으로 삭제됐습니다.");
				} else {
					System.out.println(inputId + " 가 정상적으로 삭제되지 못했습니다.");
				}
				
				break;
			case 4: // 트리의 저장된 정보를 출력
				System.out.println("트리의 정보를 출력합니다.");
				System.out.println("트리의 갯수 : " + tree.getSize());
				System.out.print("트리의 정보 : ");
				tree.print();
				break;
			case 5: // 시스템 종료	
				System.out.println("종료합니다.....");
				return;
			}
		}
	}
}
