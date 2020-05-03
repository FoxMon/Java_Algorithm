package Shape;
import java.util.Scanner;

// ShapeArrayMain.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-07
// Shape 인터페이스를 구현한 클래스들의 기능들을 테스트해보자

public class ShapeArrayMain { // 도형 배열 클래스 구현
	public static void main(String[] args) {
		int circleNum; // 원의 개수
		int triangleNum; // 삼각형의 개수
		Shape shapeArr[]; // 도형 배열 선언
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("hw4_4 : 201635006 컴퓨터공학과 김준호");
		
		System.out.print("원 갯수 입력 : "); // 원 갯수 입력받음
		circleNum = userInput.nextInt();
		System.out.print("삼각형 갯수 입력 : "); // 삼각형 갯수 입력받음 
		triangleNum = userInput.nextInt();
		
		int total = circleNum + triangleNum; // 전체 도형의 개수
		shapeArr = new Shape[total]; // 도형의 개수만큼 생성
		
		System.out.println(circleNum + "개의 원 정보(반지름)을 입력하세요 : ");
		for(int i = 0; i < circleNum; i++) { // 원 객체배열 생성 및 반지름 초기화
			shapeArr[i] = new Circle();
			Circle tempCircle = (Circle)shapeArr[i]; // 다운캐스팅
			tempCircle.setRadius(userInput.nextDouble()); // 원 정보 입력
			shapeArr[i] = tempCircle; // 다시 대입
		}
		
		System.out.println(triangleNum + "개의 삼각형 정보(밑변과 높이)를 입력하세요 : ");
		for(int i = circleNum; i  < total; i++) { // 삼각형 객체배열 생성 및 밑변 높이 초기화
			shapeArr[i] = new Triangle();
			Triangle tempTri = (Triangle)shapeArr[i]; // 다운캐스팅
			tempTri.setWidth(userInput.nextDouble()); // 밑변 입력받음
			tempTri.setHeight(userInput.nextDouble()); // 높이 입력받음
			shapeArr[i] = tempTri; // 다시대입
		}
		
		System.out.println(total + "개의 도형 정보와 면적 = "); // 도형의 정보 출력
		for(int i = 0; i < total; i++) {
			System.out.println(shapeArr[i].toString());
		}
	}
}
