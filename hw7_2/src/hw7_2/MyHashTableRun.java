package hw7_2;

import java.util.Scanner;

// MyHashTableRun.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-05-09
// �ؽ����̺� ü�̴� ������� ������ Ŭ������ ����� �׽�Ʈ�غ����� ����.

public class MyHashTableRun { // HashTable ��� �׽�Ʈ
	public static void main(String[] args) {
		System.out.println("hw7_2 : ����ȣ");
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("�ؽ����̺� ũ�� �Է� : ");
		int size = userInput.nextInt();
		MyHashTable myHash = new MyHashTable(size); // �ؽ����̺� ����
		int stuID, mode, score;
		
		while(true) { // menu
			System.out.print("1:���� 2:�˻� 3:���� 4:���̺���� 5:���� ---> ");
			mode = userInput.nextInt();
			
			switch(mode) {
			case 1: // ����
				System.out.print("������ �й�, ����(������)�� �Է��ϼ���:");
				stuID = userInput.nextInt();
				score = userInput.nextInt();
				
				if(myHash.put(stuID, score)) { // ���Լ���
					System.out.println(stuID + ", " + score + " ���� ����");
				} else { // ���Խ���
					System.out.println("���� ����");
				}
				break;
				
			case 2: // �˻�
				System.out.print("�˻��� �й��� �Է��ϼ���:");
				stuID = userInput.nextInt();
				
				if(myHash.get(stuID) != -1) { // Ž������
					System.out.println(stuID + "�� �л��� ������ " + myHash.get(stuID) + "�Դϴ�.");
				} else { // Ž������
					System.out.println("�л��� ã�� ���߽��ϴ�.");
				}
				break;
				
			case 3: // ����
				System.out.print("������ �й�(������)�� �Է��ϼ���:");
				stuID = userInput.nextInt();
				
				if(myHash.remove(stuID)) { // ��������
					System.out.println(stuID + "���� ����");
				} else { // ��������
					System.out.println("���� ����");
				}
				break;
				
			case 4: // ���
				myHash.print();
				break;
				
			case 5: // ����
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}
	}
}
