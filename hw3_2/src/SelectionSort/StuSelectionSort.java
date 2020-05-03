package SelectionSort;

// StuSelectionSort.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-04-01
// �л��� �̸� ������ ������������ �����ϴ� �������� Ŭ���� �����

public class StuSelectionSort { // ���������� �����ϴ� Ŭ���� ( ��ü�� ������ ������ �ƴ϶�, �޼ҵ�鸸 �̿��ϴ� ���� �����̱⿡ static���� �ۼ� )
	private static boolean compare(String name1, String name2 ) { // �� �л��� �̸��� ����
		return ( name1.compareTo(name2) < 0 ); // name1�� �̸��� ������ ���� ���� ���, ��
	}
	
	private static void swap(StudentInfo[] student, int min, int max) { // �� ���Ҹ� ��ȯ��
		StudentInfo info = student[min];
		student[min] = student[max];
		student[max] = info;
	}
	
	public static void selectsort(StudentInfo[] student) { // �л����� ������ �Ѱܹް�, �������� ������
		int total = student.length; // �л��� ��ü �ο� ��
		
		for(int i = total - 1; i >= 0; i--) { // �л� �� ��ŭ �ݺ��� ����
			int max = i; // �ڿ������� �����. ( �ִ밪 ã�� �ε��� )
			
			for(int j = ( max - 1 ); j >= 0; j--) { // ���� �ε������� ä����
				if(compare(student[max].getName(), student[j].getName())) { // �������� ���� ( �� ���� �� ) �Ͱ� �� ���� �ε��� ��
					max = j; // �� ���� ���� �� ũ�� max�� �ε����� j�� ����
				}
			}
			
			swap(student, i, max); // �׸��� ������ �ε����� �ٲ���
		}
	}
}
