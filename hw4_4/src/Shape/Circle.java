package Shape;

// Circle.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-07
// Shape 인터페이스를 구현하여 Circle 클래스를 작성해보자

public class Circle implements Shape {  // Circle 클래스 정의
	private double radius; // 반지름
	
	@Override
	public double getArea() { return RADIAN * this.radius * this.radius; } // 면적 구하는 메소드 구현
	
	@Override
	public String toString() { return "원의 반지름 = " + this.radius + " 면적 = " + getArea(); } // 원의 정보 출력하는 메소드 구현
	
	public void setRadius(double radius) { this.radius = radius; } // 반지름 설정자
	public double getRadius() { return this.radius; } // 반지름 접근자
}
