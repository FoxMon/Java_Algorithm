package BinarySearchTree;

// BinarySearchTree.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-21
// 이진탐색트리 Class 작성하기

public class BinarySearchTree {
	private Node root;
	private int size;
	
	public BinarySearchTree() { // 생성자
		root = null;
		size = 0;
	}
	
	public int getSize() { return size; } // 저장된 노드의 수 반환
	
	public boolean contains(String id) { return ( id.equals(contains(root, id)) ); } // ID가 포함됐는지 확인
	
	private String contains(Node root, String id) { // contains 메소드 오버로딩
		if(root == null) {
			return null;
		}
		
		int comp = root.id.compareTo(id);
		
		if(comp < 0) { // 오른쪽 자식에 있을 경우
			return contains(root.right, id);
		} else if(comp > 0) { // 왼쪽 자식에 있을경우
			return contains(root.left, id);
		} else { // 찾은 경우
			return root.id;
		}	
	}
	
	public boolean add(String id) { // 트리에 노드 삽입
		if(contains(id)) { // 이미 있는 ID인 경우
			
			return false; // false
		}
		
		root = add(root, id); // 새로운 노드 추가 성공 시 true
		size++;
		
		return true;
	}
	
	private Node add(Node root, String id) { // 삽입 메소드 오버로딩
		if(root == null) {
			return new Node(id);
		}
		
		int comp = root.id.compareTo(id);
		
		if(comp < 0) { // 오른쪽 자식에 있는 경우
			root.right = add(root.right, id);
		} else if(comp > 0) { // 왼쪽 자식에 있는 경우
			root.left = add(root.left, id);
		}
		
		return root; // 삽입이 완료된 경우, 루트노드 반환
	}
	
	public boolean remove(String id) { // 삭제연산 수행
		if(contains(id)) { // ID가 정상 삭제됐으면 원래 root와 연결 후, true반환
			root = remove(root, id);
			size--;
			
			return true;
		}
		
		return false; // 삭제하려는 ID가 없으면 false
	}
	
	private Node remove(Node root, String id) { // 삭제연산 오버로딩
		if(root == null) {
			return null;
		}
		
		int comp = root.id.compareTo(id); 
		
		if(comp < 0) { // 오른쪽 자식에 있는 경우
			root.right = remove(root.right, id);
		} else if(comp > 0) { // 왼쪽 자식에 있는 경우
			root.left = remove(root.left, id);
		} else { // 삭제할 노드 발견
			if(root.right == null) { // Case 1
				return root.left;
			}
			
			if(root.left == null) { // Case 2
				return root.right;
			}
			
			Node temp = root;
			root = minimum(temp.right);
			root.right = deleteMinimum(temp.right); // 중위후속자
			root.left = temp.left; // 원래모양 복구
		}
		
		return root;
	}
	
	private String minimum() { // 최솟값 찾기
		if(root == null) { // 자식이 없으면 null
			return null;
		}
		
		return minimum(root.left).id; // 최솟값 반환
	}
	
	private Node minimum(Node root) { // 최솟값 노드 찾는 메소드 오버로딩
		if(root.left == null) { // 왼쪽 자식노드가 없으면 이 노드 반환
			return root;
		}
		
		return minimum(root.left); // 있으면 계속 내려감
	}
	
	private Node deleteMinimum(Node root) { // 최소값을 가진 루트노드 삭제
		if(root == null) { 
			return null;
		}
		
		if(root.left == null) { // 오른쪽 자식노드를 그 위의 부모노드와 이어줘야함
			return root.right;
		}
		
		root.left = deleteMinimum(root.left); // 재연결
		
		return root;
	}
	
	public void print() { // 중순위 하면서 트리의 정보 출력
		inorder(root); 
		System.out.println();
	}
	
	private void inorder(Node root) { // 중순위 연산
		if(root != null) {
			inorder(root.left);
			System.out.print(root.id + " ");
			inorder(root.right);
		}
	}
	
	private class Node { // 트리의 Node 에 대한 정보
		private String id;
		private Node left;
		private Node right;
		
		private Node(String id) { // Node의 생성자
			this.id = id;
			left = null;
			right = null;
		}
	}
}
