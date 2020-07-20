package Graph;

// MyDirectedGraph.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-06-05
// ���� ���� �׷��� Ŭ������ �ۼ��غ����� ����.

public class MyDirectedGraph {
	private static final int EMPTY = -100; // ��������� ��Ÿ���� ���(���Ƿ� -100����)
	private Node[] list; // ��������Ʈ
	private int vertexNum; // ���� ��
	
	public MyDirectedGraph(int vertexNum) { // ������
		this.vertexNum = vertexNum;
		list = new Node[vertexNum];
		
		for(int i = 0; i < vertexNum; i++) { // ����Ʈ�� ������ȣ �ʱ�ȭ
			list[i] = new Node(EMPTY, null);
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
}
