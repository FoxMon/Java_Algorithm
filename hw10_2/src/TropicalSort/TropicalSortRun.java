package TropicalSort;

import java.util.Scanner;

// TropicalSortRun.java
// 201635006 컴퓨터공학과 김준호
// 2020-06-11
// 위상정렬을 수행하는 클래스를 작성해보자.

public class TropicalSortRun {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		MyDirectedGraph graph; // 그래프
		int numOfVertex;
		int numOfEdge;
		
		System.out.println("hw10_2 : 김준호");
		System.out.println("위상 정렬을 수행합니다. DAG를 입력하세요.");
		
		System.out.print("정점 수 입력 : "); // 정점 수 
		numOfVertex = userInput.nextInt();
		graph = new MyDirectedGraph(numOfVertex);
		
		System.out.print("간선 수 입력 : "); // 간선 수
		numOfEdge = userInput.nextInt();
		
		System.out.println(numOfEdge + "개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		int vertex1, vertex2;
		
		for(int i = 0; i < numOfEdge; i++) {
			System.out.print("간선" + (i + 1) + " 입력 : "); // 간선 입력
			vertex1 = userInput.nextInt();
			vertex2 = userInput.nextInt();
			
			if(!graph.addEdge(vertex1, vertex2)) { // 간선 추가 실패시
				break;
			}
		}
		
		graph.printAdjacencyList(); // 간선 정보 출력
		graph.topologicalSort(); // 위상 정렬 수행
		//graph.dfs(0);
	}
}
