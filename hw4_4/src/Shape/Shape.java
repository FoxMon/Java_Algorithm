package Shape;

// Shape.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-07
// 도형 인터페이스 작성하기

public interface Shape { // 도형 인터페이스
	final public double RADIAN = 3.14; // 원주율 상수 정의
	
	public abstract double getArea(); // 면적을 반환하는 메소드
}
