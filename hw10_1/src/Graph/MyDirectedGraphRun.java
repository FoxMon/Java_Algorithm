package Graph;

import java.util.Scanner;

// MyDirectedGraphRun.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-06-05
// ���� ���� �׷��� Ŭ������ ����� �����غ���.

public class MyDirectedGraphRun {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		MyDirectedGraph graph; // �׷���
		int numOfVertex;
		int numOfEdge;
		
		System.out.println("hw10_1 ����ȣ");
		
		System.out.print("���� �� �Է� : "); // ���� �� 
		numOfVertex = userInput.nextInt();
		graph = new MyDirectedGraph(numOfVertex);
		
		System.out.print("���� �� �Է� : "); // ���� ��
		numOfEdge = userInput.nextInt();
		
		System.out.println(numOfEdge + "���� ���� �Է�(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		int vertex1, vertex2;
		
		for(int i = 0; i < numOfEdge; i++) {
			System.out.print("����" + (i + 1) + " �Է� : "); // ���� �Է�
			vertex1 = userInput.nextInt();
			vertex2 = userInput.nextInt();
			
			if(!graph.addEdge(vertex1, vertex2)) { // ���� �߰�
				break;
			}
		}
		
		graph.printAdjacencyList(); // ���� ���� ���
	}
}
