package BinarySearchTree;

// BinarySearchTree.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-21
// ����Ž��Ʈ�� Class �ۼ��ϱ�

public class BinarySearchTree {
	private Node root;
	private int size;
	
	public BinarySearchTree() { // ������
		root = null;
		size = 0;
	}
	
	public int getSize() { return size; } // ����� ����� �� ��ȯ
	
	public boolean contains(String id) { return ( id.equals(contains(root, id)) ); } // ID�� ���Եƴ��� Ȯ��
	
	private String contains(Node root, String id) { // contains �޼ҵ� �����ε�
		if(root == null) {
			return null;
		}
		
		int comp = root.id.compareTo(id);
		
		if(comp < 0) { // ������ �ڽĿ� ���� ���
			return contains(root.right, id);
		} else if(comp > 0) { // ���� �ڽĿ� �������
			return contains(root.left, id);
		} else { // ã�� ���
			return root.id;
		}	
	}
	
	public boolean add(String id) { // Ʈ���� ��� ����
		if(contains(id)) { // �̹� �ִ� ID�� ���
			
			return false; // false
		}
		
		root = add(root, id); // ���ο� ��� �߰� ���� �� true
		size++;
		
		return true;
	}
	
	private Node add(Node root, String id) { // ���� �޼ҵ� �����ε�
		if(root == null) {
			return new Node(id);
		}
		
		int comp = root.id.compareTo(id);
		
		if(comp < 0) { // ������ �ڽĿ� �ִ� ���
			root.right = add(root.right, id);
		} else if(comp > 0) { // ���� �ڽĿ� �ִ� ���
			root.left = add(root.left, id);
		}
		
		return root; // ������ �Ϸ�� ���, ��Ʈ��� ��ȯ
	}
	
	public boolean remove(String id) { // �������� ����
		if(contains(id)) { // ID�� ���� ���������� ���� root�� ���� ��, true��ȯ
			root = remove(root, id);
			size--;
			
			return true;
		}
		
		return false; // �����Ϸ��� ID�� ������ false
	}
	
	private Node remove(Node root, String id) { // �������� �����ε�
		if(root == null) {
			return null;
		}
		
		int comp = root.id.compareTo(id); 
		
		if(comp < 0) { // ������ �ڽĿ� �ִ� ���
			root.right = remove(root.right, id);
		} else if(comp > 0) { // ���� �ڽĿ� �ִ� ���
			root.left = remove(root.left, id);
		} else { // ������ ��� �߰�
			if(root.right == null) { // Case 1
				return root.left;
			}
			
			if(root.left == null) { // Case 2
				return root.right;
			}
			
			Node temp = root;
			root = minimum(temp.right);
			root.right = deleteMinimum(temp.right); // �����ļ���
			root.left = temp.left; // ������� ����
		}
		
		return root;
	}
	
	private String minimum() { // �ּڰ� ã��
		if(root == null) { // �ڽ��� ������ null
			return null;
		}
		
		return minimum(root.left).id; // �ּڰ� ��ȯ
	}
	
	private Node minimum(Node root) { // �ּڰ� ��� ã�� �޼ҵ� �����ε�
		if(root.left == null) { // ���� �ڽĳ�尡 ������ �� ��� ��ȯ
			return root;
		}
		
		return minimum(root.left); // ������ ��� ������
	}
	
	private Node deleteMinimum(Node root) { // �ּҰ��� ���� ��Ʈ��� ����
		if(root == null) { 
			return null;
		}
		
		if(root.left == null) { // ������ �ڽĳ�带 �� ���� �θ���� �̾������
			return root.right;
		}
		
		root.left = deleteMinimum(root.left); // �翬��
		
		return root;
	}
	
	public void print() { // �߼��� �ϸ鼭 Ʈ���� ���� ���
		inorder(root); 
		System.out.println();
	}
	
	private void inorder(Node root) { // �߼��� ����
		if(root != null) {
			inorder(root.left);
			System.out.print(root.id + " ");
			inorder(root.right);
		}
	}
	
	private class Node { // Ʈ���� Node �� ���� ����
		private String id;
		private Node left;
		private Node right;
		
		private Node(String id) { // Node�� ������
			this.id = id;
			left = null;
			right = null;
		}
	}
}
