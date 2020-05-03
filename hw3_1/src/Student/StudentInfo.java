package Student;

// StudentInfo.java
// 201635006 ��ǻ�Ͱ��а� ����ȣ
// 2020-03-31
// �л��� ������ �����ϴ� Ŭ������ �ۼ��ϱ�.

public class StudentInfo { // �л������� �����ϴ� Class
	// ��� ������ ���� ������ private
	private String name; // Student name
	private int id; // Student ID
	private double score; // Student score
	
	public StudentInfo() { // �⺻ ������, ��� ��������� 0���� �ʱ�ȭ
		this.name = null;
		this.id = 0;
		this.score = 0;
	}
	
	// private ���� �����ڿ� �����ϱ� ���ؼ��� �޼ҵ带 �̿��� �����ؾ��� ����, get, set �޼ҵ带 ����� ��
	public void setName(String name) { // �̸������� �����ϱ� ���� �޼ҵ�
		this.name = name;
	}
	
	public void setId(int id) { // �й������� �����ϱ� ���� �޼ҵ�
		this.id = id;
	}
	
	public void setScore(double score) { // ���������� �����ϱ� ���� �޼ҵ�
		this.score = score;
	}
	
	public String getName() { // �̸������� �����ϱ� ���� �޼ҵ�
		return this.name;
	}
	
	public int getId() { // �й������� �����ϱ� ���� �޼ҵ�
		return this.id;
	}
	
	public double getScore() { // ���������� �����ϱ� ���� �޼ҵ�
		return this.score;
	}
}
