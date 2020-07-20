package hw7_1;

// MyHashTable.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-05-08
// �ؽ����̺� Ŭ������ ����� ������ ����.

public class MyHashTable { // HashTable
	private static final int EMPTY = -1; // empty
	private static final int DELETED = -2; // deleted
	private int[] hashTable; // table
	private int size; // size
	
	public MyHashTable(int size) { // ������
		this.size = size;
		hashTable = new int[size];
		
		for(int i = 0; i < size; i++) {
			hashTable[i] = EMPTY;
		}
	}
	
	public void print() { // �ؽ����̺� ���� ���
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
	
	public boolean put(int key) { // ����
		int initialIndex = hash(key); // �ʱ���ġ
		int i = initialIndex;
		int linear = 1; // Linear probing
		
		while(true) {
			if(hashTable[i] == EMPTY || hashTable[i] == DELETED) { // ���� ����
				hashTable[i] = key;
				
				return true;
			}
			
			i = hash(initialIndex, linear); // �������
			linear++;
			
			if(i == initialIndex) { // ���� �ּ� ����ε� �������� 1�� �Ѿ�� ���
				return false;
			}
		}
	}
	
	public boolean contains(int key) { // ID���翩��
		int index = search(key);
		
		return (index >= 0);
	}
	
	public boolean remove(int key) { // ID����
		int index = search(key);
		
		if(index >= 0) { // ���� ����
			hashTable[index] = DELETED;
			
			return true;
		}
		
		return false; // ���� ����
	}
	
	private int hash(int x) { // �ؽ��Լ�
		return (x % size);
	}
	
	private int hash(int i, int x) { // ������� �ؽ��Լ�
		return (i + x) % size;
	}
	
	private int search(int key) { // IDŽ��
		int initialIndex = hash(key);
		int i = initialIndex;
		int linear = 1;
		
		while(true) {
			if(hashTable[i] != EMPTY) {
				if(hashTable[i] == key) { // Ž������
					return hash(key);
				}
			}
			i = hash(initialIndex, linear); // ������� ����
			linear++;
			
			if(i == initialIndex) { // Ž�� ����
				break;
			}
		}
		
		return EMPTY; // ���� �� ��ȯ
	}
}
