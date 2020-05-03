package BubbleSort;
import java.util.Scanner;

// StudentSortMain.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-02
// �л��� �̸� ������ ������������ �����ϴ� Ŭ������ �̿��Ͽ� Ŭ���� ���� ��ɵ��� �׽�Ʈ �غ���

public class StudentSortMain {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // Scanner ��ü ����
		int total; // �л����� ��
		
		System.out.println("hw3_3 : 201635006 ��ǻ�Ͱ��а� ����ȣ");
		System.out.print("�л� �� �Է� : ");
		
		total = userInput.nextInt(); // �л� ���� �Է� ����
	
		StudentInfo student[] = new StudentInfo[total]; // �л� ����ŭ ��ü�迭�� ����
		
		for(int i = 0; i < total; i++) { // ��ü�迭�� ���Ҹ��� �����ڸ� ȣ���Ͽ� �ʱ�ȭ ����
			student[i] = new StudentInfo();
		}
		
		System.out.println(total + "���� �л� ������ �Է��ϼ���.");
		
		for(int i = 0; i < total; i++) { // �л����� ������ �Է¹���
			student[i].setName(userInput.next()); // �л��̸�
			student[i].setId(userInput.nextInt()); // �й�
			student[i].setScore(userInput.nextDouble()); // �л� ����
		}
		
		System.out.println("���� �������� ���� ��� = ");
		
		StuBubbleSort.bubblesort(student); // �������� ����
		
		for(int i = 0 ; i < total; i++) { // �������� ��� ���
			System.out.println(student[i].getName() + " " + student[i].getId() + " " + student[i].getScore());
		}
	}
}
