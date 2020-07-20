package TropicalSort;

import java.util.Scanner;

// TropicalSortRun.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-06-11
// ���������� �����ϴ� Ŭ������ �ۼ��غ���.

public class TropicalSortRun {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		MyDirectedGraph graph; // �׷���
		int numOfVertex;
		int numOfEdge;
		
		System.out.println("hw10_2 : ����ȣ");
		System.out.println("���� ������ �����մϴ�. DAG�� �Է��ϼ���.");
		
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
			
			if(!graph.addEdge(vertex1, vertex2)) { // ���� �߰� ���н�
				break;
			}
		}
		
		graph.printAdjacencyList(); // ���� ���� ���
		graph.topologicalSort(); // ���� ���� ����
		//graph.dfs(0);
	}
}
