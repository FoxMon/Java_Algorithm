package Shape;
import java.lang.Comparable;

// ShapeSort.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-09
// ���������� �����ϴ� Ŭ������ ����� ������ ����

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
	
	private static boolean compare(Shape comp1, Shape comp2 ) { // �� ��ü�� ������ ��
		return ( comp1.getArea() < comp2.getArea() );
	}
}
