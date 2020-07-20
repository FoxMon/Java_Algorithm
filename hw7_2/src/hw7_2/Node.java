package hw7_2;

// Node.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-09
// 해시테이블에 들어갈 노드구조를 작성해 보도록 하자.

public class Node { // Node
	private Node next; // next node
	private int key; // score
	private int value; // student id
	
	public Node(Node next, int key, int value) { // constructor
		this.next = next;
		this.key = key;
		this.value = value;
	}
	
	public int getKey() { return this.key; }
	public int getValue() { return this.value; }
	public Node getNext() { return this.next; }
	
	public void setNext(Node next) { this.next = next; }
}
