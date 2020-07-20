package Graph;

// Node.java
// 201635006 컴퓨터공학과 김준호
// 2020-06-05
// 그래프를 구현하는데 필요한 Node클래스를 작성해보도록 하자.

public class Node {
	private int vertex; // 정점
	private Node link; // 다음 노드를 가리킴
	
	//생성자
	public Node(int vertex, Node link) {
		this.vertex = vertex;
		this.link = link;
	}
	
	// getter와 setter
	public void setVertex(int vertex) { this.vertex = vertex; }
	public void setLink(Node link) { this.link = link; }
	public int getVertex() { return vertex; }
	public Node getLink() { return link; }
}
