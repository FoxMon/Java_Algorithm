package Selection;
import java.util.Scanner;

// SelectionTest.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-17
// ��� ���� �ð� ���� �˰����� �����ϴ� Ŭ������ ����� �׽�Ʈ�غ���

public class SelectionTest { // ���� �˰��� �׽�Ʈ
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // ���� �Է� ��ü
		
		System.out.println("hw5_1 : ����ȣ");
		
		System.out.print("�������� �Է� : ");
		int total = userInput.nextInt();
		
		int ranArr[] = new int[total]; // �Է¹��� ������ int �迭 ����
		
		System.out.print(total + "���� ���� �Է� : ");
		
		for(int i = 0; i < total; i++) { // 15���� ���� �Է¹���
			ranArr[i] = userInput.nextInt();
		}
		
		int target; // ã������ �ε���
		
		if(total % 2 == 1) { // Ȧ���� ���
			target = (total / 2) + 1;
		} else { // ¦���� ���
			target = total / 2;
		}
		
		int middleNum = Selection.select(ranArr, 0, total - 1, target); // �迭 ������ ��� �ε��� ����
		System.out.println("�߾Ӱ� : " + middleNum); // �߾Ӱ� ���
	}
}
