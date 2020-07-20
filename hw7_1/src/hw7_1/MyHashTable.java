package hw7_1;

// MyHashTable.java
// 201635006 컴퓨터공학과 김준호
// 2020-05-08
// 해시테이블 클래스를 만들어 보도록 하자.

public class MyHashTable { // HashTable
	private static final int EMPTY = -1; // empty
	private static final int DELETED = -2; // deleted
	private int[] hashTable; // table
	private int size; // size
	
	public MyHashTable(int size) { // 생성자
		this.size = size;
		hashTable = new int[size];
		
		for(int i = 0; i < size; i++) {
			hashTable[i] = EMPTY;
		}
	}
	
	public void print() { // 해쉬테이블 정보 출력
		for(int i = 0; i < size; i++) {
			if(hashTable[i] == DELETED) {
				System.out.println("[" + i + "] " + "DELETED");
			} else if(hashTable[i] == EMPTY) {
				System.out.println("[" + i + "] " + "");
			} else {
				System.out.println("[" + i + "] " + hashTable[i]);
			}
		}
	}
	
	public boolean put(int key) { // 삽입
		int initialIndex = hash(key); // 초기위치
		int i = initialIndex;
		int linear = 1; // Linear probing
		
		while(true) {
			if(hashTable[i] == EMPTY || hashTable[i] == DELETED) { // 삽입 성공
				hashTable[i] = key;
				
				return true;
			}
			
			i = hash(initialIndex, linear); // 선형방식
			linear++;
			
			if(i == initialIndex) { // 개방 주소 방식인데 적재율이 1이 넘어가는 경우
				return false;
			}
		}
	}
	
	public boolean contains(int key) { // ID존재여부
		int index = search(key);
		
		return (index >= 0);
	}
	
	public boolean remove(int key) { // ID삭제
		int index = search(key);
		
		if(index >= 0) { // 삭제 성공
			hashTable[index] = DELETED;
			
			return true;
		}
		
		return false; // 삭제 실패
	}
	
	private int hash(int x) { // 해시함수
		return (x % size);
	}
	
	private int hash(int i, int x) { // 선형방식 해시함수
		return (i + x) % size;
	}
	
	private int search(int key) { // ID탐색
		int initialIndex = hash(key);
		int i = initialIndex;
		int linear = 1;
		
		while(true) {
			if(hashTable[i] != EMPTY) {
				if(hashTable[i] == key) { // 탐색성공
					return hash(key);
				}
			}
			i = hash(initialIndex, linear); // 선형방식 접근
			linear++;
			
			if(i == initialIndex) { // 탐색 실패
				break;
			}
		}
		
		return EMPTY; // 음의 값 반환
	}
}
