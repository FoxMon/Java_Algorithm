package Graph;

// MyDirectedGraph.java
// 201635006 컴퓨터공학과 김준호
// 2020-06-05
// 나의 방향 그래프 클래스를 작성해보도록 하자.

public class MyDirectedGraph {
	private static final int EMPTY = -100; // 비어있음을 나타내는 상수(임의로 -100으로)
	private Node[] list; // 인접리스트
	private int vertexNum; // 정점 수
	
	public MyDirectedGraph(int vertexNum) { // 생성자
		this.vertexNum = vertexNum;
		list = new Node[vertexNum];
		
		for(int i = 0; i < vertexNum; i++) { // 리스트의 정점번호 초기화
			list[i] = new Node(EMPTY, null);
		}
	}
	
	public boolean addEdge(int vertex1, int vertex2) { // 간선 추가
		if(vertex1 > (vertexNum - 1) || vertex2 > (vertexNum - 1)) { // 오류 시 이 문장 출력 후 false반환
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <" + vertex1 + ", " + vertex2 + ">");
			return false;
		}
		
		// 리스트의 앞에 계속 삽입
		list[vertex1] = new Node(vertex2, list[vertex1]); // 저장 시 리스트의 순서는 고려하지 않음
		
		return true;
	}
	
	public void printAdjacencyList() { // 정보 출력
		for(int i = 0; i < vertexNum; i++) {
			Node temp = list[i];
			
			System.out.print("정점 " + i + "에 인접한 정점 = ");
			
			while(temp != null) { // 마지막까지 탐색
				if(temp.getVertex() != EMPTY) { // 비어있는경우 출력 x
					System.out.print(temp.getVertex() + " ");
				}
				
				temp = temp.getLink();
			}
			
			System.out.println();
		}
	}
}
