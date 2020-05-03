package Student;

// StudentInfo.java
// 201635006 컴퓨터공학과 김준호
// 2020-03-31
// 학생의 정보를 관리하는 클래스를 작성하기.

public class StudentInfo { // 학생정보를 관리하는 Class
	// 멤버 변수는 접근 지정자 private
	private String name; // Student name
	private int id; // Student ID
	private double score; // Student score
	
	public StudentInfo() { // 기본 생성자, 모든 멤버변수를 0으로 초기화
		this.name = null;
		this.id = 0;
		this.score = 0;
	}
	
	// private 접근 지정자에 접근하기 위해서는 메소드를 이용해 접근해야함 따라서, get, set 메소드를 만들어 줌
	public void setName(String name) { // 이름변수를 설정하기 위한 메소드
		this.name = name;
	}
	
	public void setId(int id) { // 학번변수를 설정하기 위한 메소드
		this.id = id;
	}
	
	public void setScore(double score) { // 학점변수를 설정하기 위한 메소드
		this.score = score;
	}
	
	public String getName() { // 이름변수에 접근하기 위한 메소드
		return this.name;
	}
	
	public int getId() { // 학번변수에 접근하기 위한 메소드
		return this.id;
	}
	
	public double getScore() { // 학점변수에 접근하기 위한 메소드
		return this.score;
	}
}
