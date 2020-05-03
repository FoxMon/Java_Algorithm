package Student;
import java.util.Scanner;

// StuInfoTest.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-03-31
// StudentInfoŬ���� �迭�� �����, �پ��� ��ɵ��� ������ ���ϴ�.

public class StuInfoTest { // StudentInfo Ŭ���� �迭�� �����ϰ� main���� �پ��� ��ɵ��� ������ ���ϴ�.
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // Scanner ��ü ����
		int total;
		double average = 0; // �л����� ���� ���
		
		System.out.println("hw3_1 : 201635006 ��ǻ�Ͱ��а� ����ȣ");
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
			average += student[i].getScore(); // ����� ���ϱ� ���ؼ� �л����� ������ ��� ������
		}
		
		average = average / total; // ���� ������ �л� �ο�����ŭ ������
		
		System.out.println("���� ��� = " + average); // �л� ��� ���
		
		double maxScore = student[0].getScore(); // ���� �л��� �˾ƺ��� ���� �ְ� ������ ã�ƾ� ��
		
		for(int i = 1; i < total; i++) {
			if(maxScore < student[i].getScore()) { // maxScore�� ã��
				maxScore = student[i].getScore();
			}
		}
		
		for(int i = 0; i < total; i++) {
			if(maxScore == student[i].getScore()) { // �ְ� ������ ���ؼ� �ش� �л��� ���
				System.out.println("���� �л� ���� = " + student[i].getName()); // ���������� ��� �� ���� �л��� ����
				
				break;
			}
		}
	}
}
