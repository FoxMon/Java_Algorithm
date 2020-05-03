package BinarySearchTree;
import java.util.Scanner;

// MyBinaryTreeTest.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-21
// ����Ž��Ʈ�� Class ����� �����غ���

public class MyBinaryTreeTest {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(); // ����ִ� Ʈ����ü
		Scanner userInput = new Scanner(System.in);
		String inputId;
		int select;
		
		System.out.println("hw6_1 : ����ȣ");
		
		while(true) {
			System.out.println("1:���� 2:�˻� 3:���� 4:��ü��ȸ 5:����");
			select = userInput.nextInt(); // �޴� ����
			
			switch(select) {
			case 1: // ���� ����
				System.out.print("������ ���̵� �Է��ϼ��� : ");
				inputId = userInput.next();
				
				if(tree.add(inputId)) {
					System.out.println(inputId + " �� ���������� ���Եƽ��ϴ�.");
				} else {
					System.out.println(inputId + " �� ���������� ���Ե��� ���߽��ϴ�.");
				}
				
				break;
			case 2: // �˻� ����
				System.out.print("�˻��� ���̵� �Է��ϼ��� : ");
				inputId = userInput.next();
				if(tree.contains(inputId)) {
					System.out.println(inputId + "�� �����ϴ� ID�Դϴ�.");
				} else {
					System.out.println(inputId + "�� �������� �ʴ� ID�Դϴ�.");
				}
				break;
			case 3: // ���� ����
				System.out.print("������ ���̵� �Է��ϼ��� : ");
				inputId = userInput.next();
				
				if(tree.remove(inputId)) {
					System.out.println(inputId + " �� ���������� �����ƽ��ϴ�.");
				} else {
					System.out.println(inputId + " �� ���������� �������� ���߽��ϴ�.");
				}
				
				break;
			case 4: // Ʈ���� ����� ������ ���
				System.out.println("Ʈ���� ������ ����մϴ�.");
				System.out.println("Ʈ���� ���� : " + tree.getSize());
				System.out.print("Ʈ���� ���� : ");
				tree.print();
				break;
			case 5: // �ý��� ����	
				System.out.println("�����մϴ�.....");
				return;
			}
		}
	}
}
