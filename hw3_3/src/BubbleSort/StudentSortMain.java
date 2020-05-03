package BubbleSort;
import java.util.Scanner;

// StudentSortMain.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-02
// 학생의 이름 정보를 내림차순으로 정렬하는 클래스를 이용하여 클래스 안의 기능들을 테스트 해보기

public class StudentSortMain {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // Scanner 객체 생성
		int total; // 학생들의 수
		
		System.out.println("hw3_3 : 201635006 컴퓨터공학과 김준호");
		System.out.print("학생 수 입력 : ");
		
		total = userInput.nextInt(); // 학생 수를 입력 받음
	
		StudentInfo student[] = new StudentInfo[total]; // 학생 수만큼 객체배열을 생성
		
		for(int i = 0; i < total; i++) { // 객체배열의 원소마다 생성자를 호출하여 초기화 해줌
			student[i] = new StudentInfo();
		}
		
		System.out.println(total + "명의 학생 정보를 입력하세요.");
		
		for(int i = 0; i < total; i++) { // 학생들의 정보를 입력받음
			student[i].setName(userInput.next()); // 학생이름
			student[i].setId(userInput.nextInt()); // 학번
			student[i].setScore(userInput.nextDouble()); // 학생 점수
		}
		
		System.out.println("성명 내림차순 정렬 결과 = ");
		
		StuBubbleSort.bubblesort(student); // 버블정렬 수행
		
		for(int i = 0 ; i < total; i++) { // 버블정렬 결과 출력
			System.out.println(student[i].getName() + " " + student[i].getId() + " " + student[i].getScore());
		}
	}
}
