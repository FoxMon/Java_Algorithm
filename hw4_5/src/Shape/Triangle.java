package Shape;

// Triangle.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-07
// Shape �������̽��� �����Ͽ� Triangle Ŭ������ �ۼ��غ���

public class Triangle implements Shape { // Triangle Ŭ���� ����
	private double width; // �غ�
	private double height; // ����
	
	@Override
	public double getArea() { return (width * height) / 2; } // �ﰢ���� ���� ���ϴ� �޼ҵ� ����
	
	@Override
	public String toString() { return "�ﰢ�� �غ� = " + width + " ���� = " + height + " ���� = " + getArea(); } // �ﰢ���� ���� ����ϴ� �޼ҵ� ����
	
	public void setWidth(double width) { this.width = width; } // �غ� ������
	public void setHeight(double height) { this.height = height; } // ���� ������
	public double width() { return this.width; } // �غ� ������
	public double height() { return this.height; } // ���� ������
}
