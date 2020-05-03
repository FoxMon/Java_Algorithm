package Student;
import java.util.Scanner;

// StuInfoTest.java
// 201635006 컴퓨터공학과 김준호
// 2020-03-31
// StudentInfo클래스 배열을 만들고, 다양한 기능들을 수행해 봅니다.

public class StuInfoTest { // StudentInfo 클래스 배열을 선언하고 main에서 다양한 기능들을 수행해 봅니다.
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // Scanner 객체 생성
		int total;
		double average = 0; // 학생들의 점수 평균
		
		System.out.println("hw3_1 : 201635006 컴퓨터공학과 김준호");
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
			average += student[i].getScore(); // 평균을 구하기 위해서 학생들의 점수를 계속 더해줌
		}
		
		average = average / total; // 더한 점수를 학생 인원수만큼 나눠줌
		
		System.out.println("성적 평균 = " + average); // 학생 평균 출력
		
		double maxScore = student[0].getScore(); // 수석 학생을 알아보기 위해 최고 점수를 찾아야 함
		
		for(int i = 1; i < total; i++) {
			if(maxScore < student[i].getScore()) { // maxScore를 찾고
				maxScore = student[i].getScore();
			}
		}
		
		for(int i = 0; i < total; i++) {
			if(maxScore == student[i].getScore()) { // 최고 점수를 비교해서 해당 학생을 출력
				System.out.println("수석 학생 성명 = " + student[i].getName()); // 공동수석의 경우 맨 앞의 학생만 나옴
				
				break;
			}
		}
	}
}
