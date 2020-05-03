package Shape;

// Circle.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-07
// Shape �������̽��� �����Ͽ� Circle Ŭ������ �ۼ��غ���

public class Circle implements Shape {  // Circle Ŭ���� ����
	private double radius; // ������
	
	@Override
	public double getArea() { return RADIAN * this.radius * this.radius; } // ���� ���ϴ� �޼ҵ� ����
	
	@Override
	public String toString() { return "���� ������ = " + this.radius + " ���� = " + getArea(); } // ���� ���� ����ϴ� �޼ҵ� ����
	
	public void setRadius(double radius) { this.radius = radius; } // ������ ������
	public double getRadius() { return this.radius; } // ������ ������
}
