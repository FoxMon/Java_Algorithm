package Selection;

// Selection.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-17
// ��� ���� �ð� ���� �˰����� �����ϴ� Ŭ������ ����� ������ ����

public class Selection { // ��� �����ð� ���� �˰���
	public static int select(int ranArr[], int start, int last, int target) { // i ��° ���� ���Ҹ� ã��
		if(start == last) { // ���Ұ� �ϳ��� ���
			return ranArr[start];
		}
		
		int part = partition(ranArr, start, last); // ������ ��ġ�� �ε���
		int sel = part - start + 1; // ���� ������  ��ü ���������� ����
		
		if(target < sel) { // ���� �׷��� ���� ���
			return select(ranArr, start, part - 1, target);
		} else if (target == sel) { // ã���� ���
			return ranArr[part];
		} else { // ������ �׷��� ���� ���
			return select(ranArr, part + 1, last, target - sel);
		}
	}
	
	private static int partition(int ranArr[], int start, int last) { // �ǹ��� �߽����� ���� ������ ����
		int stand = ranArr[last]; // ���� ����
		int i = start - 1; // i�� 1���� ������
		
		for(int j = start; j <= last; j++) { // j�� 3���� ��������
			if(ranArr[j] < stand) {
				i++;
				swap(ranArr, i, j);
			}
		}
		
		swap(ranArr, i + 1, last); // ���ִ���ҿ� 2���� ù ���� ��ȯ
		
		return i + 1;
	}
	
	private static boolean compare(int comp1, int comp2) { // �ܼ� �� ���� ��
		return ( comp1 < comp2 );
	}
	
	private static void swap(int ranArr[], int i, int j) { // �ܼ� �� ���� ��ȯ
		int temp = ranArr[i];
		ranArr[i] = ranArr[j];
		ranArr[j] = temp;
	}
}
