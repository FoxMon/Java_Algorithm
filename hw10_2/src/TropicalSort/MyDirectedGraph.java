package TropicalSort;

import java.util.LinkedList; // ���������� ���� ����Ʈ

// MyDirectedGraph.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-06-11
// ���� ���� �׷��� Ŭ������ �������İ� ���̿켱 Ž���� �߰��Ͽ� �ۼ��غ����� ����.

public class MyDirectedGraph {
	private static final int EMPTY = -100; // ��������� ��Ÿ���� ���(���Ƿ� -100����)
	private static final boolean NO = false; // ���� �켱 Ž���� ���� ���. �湮 x
	private static final boolean YES = true; // �湮 o
	private Node[] list; // ��������Ʈ
	private boolean[] visit; // �湮���� �˻�
	private int vertexNum; // ���� ��
	private LinkedList<Integer> topologySort; // �������� ��� ����
	
	public MyDirectedGraph(int vertexNum) { // ������
		this.vertexNum = vertexNum;
		list = new Node[vertexNum];
		visit = new boolean[vertexNum];
		topologySort = new LinkedList<Integer>();
		
		for(int i = 0; i < vertexNum; i++) { // ����Ʈ�� ������ȣ �ʱ�ȭ �� �湮Ȯ�� �迭 �ʱ�ȭ
			list[i] = new Node(EMPTY, null);
			visit[i] = NO; // ó������ ��� ���� �湮 x
		}
	}
	
	public boolean addEdge(int vertex1, int vertex2) { // ���� �߰�
		if(vertex1 > (vertexNum - 1) || vertex2 > (vertexNum - 1)) { // ���� �� �� ���� ��� �� false��ȯ
			System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�. <" + vertex1 + ", " + vertex2 + ">");
			return false;
		}
		
		// ����Ʈ�� �տ� ��� ����
		list[vertex1] = new Node(vertex2, list[vertex1]); // ���� �� ����Ʈ�� ������ ������� ����
		
		return true;
	}
	
	public void printAdjacencyList() { // ���� ���
		for(int i = 0; i < vertexNum; i++) {
			Node temp = list[i];
			
			System.out.print("���� " + i + "�� ������ ���� = ");
			
			while(temp != null) { // ���������� Ž��
				if(temp.getVertex() != EMPTY) { // ����ִ°�� ��� x
					System.out.print(temp.getVertex() + " ");
				}
				
				temp = temp.getLink();
			}
			
			System.out.println();
		}
	}
	
	// �������İ� DFS�� �߰���
	int cnt = 0;
	
	private void dfs(int vertex) { // ���̿켱 Ž��
		visit[vertex] = YES; // �湮ǥ��
		
		if(list[vertex].getVertex() == EMPTY && visit[vertex] == YES) { // �������
			topologySort.addFirst(vertex);
			return;
		}
		
		if(visit[list[vertex].getVertex()] == NO) {
			dfs(list[vertex].getVertex());
		}
		
		topologySort.addFirst(vertex);
	}
	
	public void topologicalSort() { // ��������
		for(int i = 0; i < vertexNum; i++) { // No�� �ʱ�ȭ
			visit[i] = NO;
		}
		
		for(int i = 0; i < vertexNum; i++) { // ������ �����ʹ� ������
			if(visit[i] == NO) {
				dfs(i);
			}
		}
		
		System.out.print("���� ���� ��� : ");
		for(int i = 0; i < topologySort.size(); i++) { // �������� ��� ���
			System.out.print(topologySort.get(i) + " ");
		}
	}
}
