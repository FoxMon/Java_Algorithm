package Shape;
import java.lang.Comparable;

// ShapeSort.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-09
// 2020-04-14 heapSort �߰�
// ����, �������� �����ϴ� Ŭ������ ����� ������ ����

public class ShapeSort {
	public static void seperate(Shape[] shapeArr) { // �迭�� �ݹ� ������ ���� �����ϴ� �޼ҵ�
		Shape[] temp = new Shape[shapeArr.length]; // �ӽù迭��ü�� ������
		
		seperate(shapeArr, temp, 0, shapeArr.length - 1); // �ݹݾ� ������ ���� sort �Լ��� ȣ����
	}
	
	private static void seperate(Shape[] shapeArr, Shape[] temp, int low, int high) { // �迭�� �ݹ� ������ �޼ҵ� �����ε�
		if(high <= low) { // ��������
			return;
		}
		
		int mid = low + (high - low) / 2; // �߰� Index ����
		
		seperate(shapeArr, temp, low, mid); // �ݹ� ������ ������. ( ��������� ��� ȣ���� )
		seperate(shapeArr, temp, mid+1, high); // �޺κе� �ݹ� ������ ������
		merge(shapeArr, temp, low, high);
	}

	private static void merge(Shape[] shapeArr, Shape[] temp, int low, int high) { // �ݹ� ���� �κе��� �պ���
		int i = low;
		int mid = low + (high - low) / 2;
		int j = mid + 1;
		
		for(int k = low; k <= high; k++) {
			if(i > mid) { // �պκ� ���� �������ٸ�
				temp[k] = shapeArr[j++];
			} else if(j > high) { // �� �κ��� �������ٸ�
				temp[k] = shapeArr[i++];
			} else if(compare(shapeArr[j], shapeArr[i])) { // �߰� �� �κ��� �� ���� ���
				temp[k] = shapeArr[j++];
			} else {
				temp[k] = shapeArr[i++]; // low �κ��� �� ���� ���
			}
 		}
		
		for(int k = low; k <= high; k++) { // ������ �迭�� �ӽù迭�� ������
			shapeArr[k] = temp[k];
		}
	}
	
	public static void heapSort(Shape[] shapeArr, int size) { // �������� ������
		int heapSize = size - 1;
		
		buildHeap(shapeArr, heapSize); // �ִ������� ����
		
		for(int i = heapSize ; i > 0; i--) { // ������ ����
			swap(shapeArr, 0, i); // �ִ��� �� �ڷ� ������
			heapify(shapeArr, 0, i - 1); // �ϳ� ���ҵ� ä�� �ִ��� �������
		}
	}
	
	private static void buildHeap(Shape[] shapeArr, int heapSize) { // ������ ����
		for(int i = (heapSize / 2) - 1; i >= 0; i--) { // ������尡 �ƴ� ����� �� ������ ���
			heapify(shapeArr, i, heapSize);
		}
	}
	
	private static void heapify(Shape[] shapeArr, int parent, int heapSize) { // �� ������ �����
		int left = (parent * 2) + 1; // �����ڽ�
		int right = (parent * 2) + 2; // �������ڽ�
		int bigger; // �� ū ���� �ε���
		
		// �� ū �ڽ��� ������
		if(right <= heapSize) { // �� �ڽ��� ������ ���
			if(compare(shapeArr[left], shapeArr[right])) {
				bigger = right;
			} else {
				bigger = left;
			}
		} else if(left <= heapSize) { // �ϳ��� �ڽĸ� ������ ���
			bigger = left;
		} else { // ��������� ��� ��.
			return;
		}
		
		if(compare(shapeArr[parent], shapeArr[bigger])) { // �θ� �� �۴ٸ� bigger�� ��ȯ
			swap(shapeArr, parent, bigger);
			heapify(shapeArr, bigger, heapSize); // ��������� ����
		}
	}
	
	private static void swap(Shape[] shapeArr, int i, int j) { // �� �ε����� ������ ��ȯ����
		Shape temp = shapeArr[i];
		shapeArr[i] = shapeArr[j];
		shapeArr[j] = temp;
	}
	
	private static boolean compare(Shape comp1, Shape comp2 ) { // �� ��ü�� ������ ��
		return ( comp1.getArea() < comp2.getArea() );
	}
}
