package TropicalSort;

import java.util.LinkedList; // 위상정렬을 위한 리스트

// MyDirectedGraph.java
// 201635006 컴퓨터공학과 김준호
// 2020-06-11
// 나의 방향 그래프 클래스를 위상정렬과 깊이우선 탐색을 추가하여 작성해보도록 하자.

public class MyDirectedGraph {
	private static final int EMPTY = -100; // 비어있음을 나타내는 상수(임의로 -100으로)
	private static final boolean NO = false; // 깊이 우선 탐색에 사용될 상수. 방문 x
	private static final boolean YES = true; // 방문 o
	private Node[] list; // 인접리스트
	private boolean[] visit; // 방문여부 검사
	private int vertexNum; // 정점 수
	private LinkedList<Integer> topologySort; // 위상정렬 결과 저장
	
	public MyDirectedGraph(int vertexNum) { // 생성자
		this.vertexNum = vertexNum;
		list = new Node[vertexNum];
		visit = new boolean[vertexNum];
		topologySort = new LinkedList<Integer>();
		
		for(int i = 0; i < vertexNum; i++) { // 리스트의 정점번호 초기화 및 방문확인 배열 초기화
			list[i] = new Node(EMPTY, null);
			visit[i] = NO; // 처음에는 모든 정점 방문 x
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
	
	// 위상정렬과 DFS를 추가함
	int cnt = 0;
	
	private void dfs(int vertex) { // 깊이우선 탐색
		visit[vertex] = YES; // 방문표시
		
		if(list[vertex].getVertex() == EMPTY && visit[vertex] == YES) { // 종료시점
			topologySort.addFirst(vertex);
			return;
		}
		
		if(visit[list[vertex].getVertex()] == NO) {
			dfs(list[vertex].getVertex());
		}
		
		topologySort.addFirst(vertex);
	}
	
	public void topologicalSort() { // 위상정렬
		for(int i = 0; i < vertexNum; i++) { // No로 초기화
			visit[i] = NO;
		}
		
		for(int i = 0; i < vertexNum; i++) { // 정점의 순서와는 무관함
			if(visit[i] == NO) {
				dfs(i);
			}
		}
		
		System.out.print("위상 정렬 결과 : ");
		for(int i = 0; i < topologySort.size(); i++) { // 위상정렬 결과 출력
			System.out.print(topologySort.get(i) + " ");
		}
	}
}
