package BubbleSort;

//StuBubbleSort.java
//201635006 ��ǻ�Ͱ��а� ����ȣ
//2020-04-02
//�л��� �̸� ������ ������������ �����ϴ� �������� Ŭ���� �����

public class StuBubbleSort { // ���������� �����ϴ� Ŭ������ ����� ������ ���� ( �޼ҵ常 ����� ���̹Ƿ� static���� �ۼ� )
	private static boolean compare(double score1, double score2) { // �� �л��� ������ ����
		return ( score1 < score2 ); // ������ ��
	}
	
	private static void swap(StudentInfo[] student,  int min, int max) { // �� �л��� ������ ��ȯ��
		StudentInfo temp = student[min];
		student[min] = student[max];
		student[max] = temp;
	}
	
	public static void bubblesort(StudentInfo[] student) { // �����Ʈ�� ������ ( �ܺο��� ����ϹǷ� �������� public )
		int total = student.length; // �迭�� ����
		boolean bubbleFlag = true; // ���ʿ��� ������ ���̱� ���ؼ� flag�� ������
		
		for(int i = ( total - 1 ); i > 0; i--) { // ���� ���� ���ڸ� ������ ���� ����
			for(int j = 0; j < i; j++) {
				if(compare(student[j].getScore(), student[j + 1].getScore())) { // ���Ұ� ���� ���� ���������� ����
					swap(student, j, j+1); // ��� ��������
					bubbleFlag = false; // ��ȯ�� �̷�� �������� false�� �ٲ���
				}
			}
			
			if(bubbleFlag == true) { // �� ���� ��ȯ�� �̷������ �ʾҴٸ�
				return; // �� ���� �Լ��� ��������
			}
		}
	}
}
