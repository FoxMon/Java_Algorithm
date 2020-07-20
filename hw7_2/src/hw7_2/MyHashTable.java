package hw7_2;

// MyHashTable.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-09
// 해시테이블 클래스를 만들어 보도록 하자(체이닝방식).

public class MyHashTable { // HashTable
	private static final int EMPTY = -1; // empty
	private Node[] header; // node
	private int size; // size
	
	public MyHashTable(int size) { // 생성자
		this.size = size;
		header = new Node[size];
		
		for(int i = 0; i < size; i++) {
			header[i] = new Node(null, EMPTY, EMPTY);
		} 
	}
	
	public void print() { // 해쉬테이블 정보 출력
		for(int i = 0; i < size; i++) {
			if(header[i].getKey() == EMPTY) {
				System.out.println("[" + i + "] " + "");
			} else {
				System.out.print("[" + i + "] ");
				Node temp = header[i];
				
				while(temp != null) {
					if(temp.getKey() == EMPTY) { // Empty는 출력하지 않음
						break;
					}
					System.out.print(temp.getKey() + " ");
					temp = temp.getNext();
				}
				System.out.println();
			}
		}
	}
	
	public boolean put(int key, int value) { // 삽입
		int head = hash(key); // 초기위치
		
		header[head] = new Node(header[head], key, value);
		
		return true;
	}
	
	public int get(int key) { // 검색
		int index = hash(key);
		Node search = header[index]; // 탐색하기 위한 임시노드
		
		while(search != null) {
			if(key == search.getKey()) { // 탐색 성공
				return search.getValue();
			}
			
			search = search.getNext();
		}
		
		return EMPTY; // 탐색 실패
	}
	
	public boolean remove(int key) { // ID삭제
		int index = hash(key);
		
		if(header[index] == null) { // 삭제 실패
			return false;
		}
	
		Node next = header[index].getNext(); // 이게 삭제될 노드임
		Node current = header[index]; 
		
		while(next != null) { // 끝까지 탐색
			if(next.getKey() == key) { // 삭제성공
				current.setNext(next.getNext());
				
				return true;
			}
			
			current = next;
			next = next.getNext();
		}
		
		return false; // 삭제실패
	}
	
	private int hash(int x) { // 해시함수
		return (x % size);
	}
}
