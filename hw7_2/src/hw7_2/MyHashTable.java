package hw7_2;

// MyHashTable.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-05-09
// �ؽ����̺� Ŭ������ ����� ������ ����(ü�̴׹��).

public class MyHashTable { // HashTable
	private static final int EMPTY = -1; // empty
	private Node[] header; // node
	private int size; // size
	
	public MyHashTable(int size) { // ������
		this.size = size;
		header = new Node[size];
		
		for(int i = 0; i < size; i++) {
			header[i] = new Node(null, EMPTY, EMPTY);
		} 
	}
	
	public void print() { // �ؽ����̺� ���� ���
		for(int i = 0; i < size; i++) {
			if(header[i].getKey() == EMPTY) {
				System.out.println("[" + i + "] " + "");
			} else {
				System.out.print("[" + i + "] ");
				Node temp = header[i];
				
				while(temp != null) {
					if(temp.getKey() == EMPTY) { // Empty�� ������� ����
						break;
					}
					System.out.print(temp.getKey() + " ");
					temp = temp.getNext();
				}
				System.out.println();
			}
		}
	}
	
	public boolean put(int key, int value) { // ����
		int head = hash(key); // �ʱ���ġ
		
		header[head] = new Node(header[head], key, value);
		
		return true;
	}
	
	public int get(int key) { // �˻�
		int index = hash(key);
		Node search = header[index]; // Ž���ϱ� ���� �ӽó��
		
		while(search != null) {
			if(key == search.getKey()) { // Ž�� ����
				return search.getValue();
			}
			
			search = search.getNext();
		}
		
		return EMPTY; // Ž�� ����
	}
	
	public boolean remove(int key) { // ID����
		int index = hash(key);
		
		if(header[index] == null) { // ���� ����
			return false;
		}
	
		Node next = header[index].getNext(); // �̰� ������ �����
		Node current = header[index]; 
		
		while(next != null) { // ������ Ž��
			if(next.getKey() == key) { // ��������
				current.setNext(next.getNext());
				
				return true;
			}
			
			current = next;
			next = next.getNext();
		}
		
		return false; // ��������
	}
	
	private int hash(int x) { // �ؽ��Լ�
		return (x % size);
	}
}
