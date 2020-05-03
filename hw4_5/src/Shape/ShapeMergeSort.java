package Shape;
import java.util.Scanner;

// ShapeMergeSort.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-09
// �������� ������������ ���������� ������ ������ ����.

public class ShapeMergeSort { // ���� �迭 Ŭ���� ����
	public static void main(String[] args) {
		int circleNum; // ���� ����
		int triangleNum; // �ﰢ���� ����
		Shape shapeArr[]; // ���� �迭 ����
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("hw4_5 : ����ȣ");
		
		System.out.print("�� ���� �Է� : "); // �� ���� �Է¹���
		circleNum = userInput.nextInt();
		System.out.print("�ﰢ�� ���� �Է� : "); // �ﰢ�� ���� �Է¹��� 
		triangleNum = userInput.nextInt();
		
		int total = circleNum + triangleNum; // ��ü ������ ����
		shapeArr = new Shape[total]; // ������ ������ŭ ����
		
		System.out.println(circleNum + "���� �� ����(������)�� �Է��ϼ��� : ");
		for(int i = 0; i < circleNum; i++) { // �� ��ü�迭 ���� �� ������ �ʱ�ȭ
			shapeArr[i] = new Circle();
			Circle tempCircle = (Circle)shapeArr[i]; // �ٿ�ĳ����
			tempCircle.setRadius(userInput.nextDouble()); // �� ���� �Է�
			shapeArr[i] = tempCircle; // �ٽ� ����
		}
		
		System.out.println(triangleNum + "���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ��� : ");
		for(int i = circleNum; i  < total; i++) { // �ﰢ�� ��ü�迭 ���� �� �غ� ���� �ʱ�ȭ
			shapeArr[i] = new Triangle();
			Triangle tempTri = (Triangle)shapeArr[i]; // �ٿ�ĳ����
			tempTri.setWidth(userInput.nextDouble()); // �غ� �Է¹���
			tempTri.setHeight(userInput.nextDouble()); // ���� �Է¹���
			shapeArr[i] = tempTri; // �ٽô���
		}
		
		System.out.println("�������� ��� " + total + "���� ���� ������ ���� = "); // ������ ���� ���
		ShapeSort.seperate(shapeArr); // �������� ����
		
		for(int i = 0; i < total; i++) { // �������ĵ� ����� ���
			System.out.println(shapeArr[i].toString());
		}
	}
}
