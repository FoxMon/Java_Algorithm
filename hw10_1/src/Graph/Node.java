package Graph;

// Node.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-06-05
// �׷����� �����ϴµ� �ʿ��� NodeŬ������ �ۼ��غ����� ����.

public class Node {
	private int vertex; // ����
	private Node link; // ���� ��带 ����Ŵ
	
	//������
	public Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
	
	// getter�� setter
	public void setVertex(int vertex) { this.vertex = vertex; }
	public void setLink(Node link) { this.link = link; }
	public int getVertex() { return vertex; }
	public Node getLink() { return link; }
}
