package Shape;

// Triangle.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-07
// Shape 인터페이스를 구현하여 Triangle 클래스를 작성해보자

public class Triangle implements Shape { // Triangle 클래스 구현
	private double width; // 밑변
	private double height; // 높이
	
	@Override
	public double getArea() { return (width * height) / 2; } // 삼각형의 넓이 구하는 메소드 구현
	
	@Override
	public String toString() { return "삼각형 밑변 = " + width + " 높이 = " + height + " 면적 = " + getArea(); } // 삼각형의 정보 출력하는 메소드 구현
	
	public void setWidth(double width) { this.width = width; } // 밑변 설정자
	public void setHeight(double height) { this.height = height; } // 높이 설정자
	public double width() { return this.width; } // 밑변 접근자
	public double height() { return this.height; } // 높이 접근자
}
