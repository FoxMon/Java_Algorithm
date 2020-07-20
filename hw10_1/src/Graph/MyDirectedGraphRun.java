package Graph;

import java.util.Scanner;

// MyDirectedGraphRun.java
// 201635006 컴퓨터공학과 김준호
// 2020-06-05
// 나의 방향 그래프 클래스의 기능을 수행해보자.

public class MyDirectedGraphRun {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		MyDirectedGraph graph; // 그래프
		int numOfVertex;
		int numOfEdge;
		
		System.out.println("hw10_1 김준호");
		
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
			
			if(!graph.addEdge(vertex1, vertex2)) { // 간선 추가
				break;
			}
		}
		
		graph.printAdjacencyList(); // 간선 정보 출력
	}
}
