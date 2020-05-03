package BubbleSort;

//StuBubbleSort.java
//201635006 컴퓨터공학과 김준호
//2020-04-02
//학생의 이름 정보를 내림차순으로 정렬하는 버블정렬 클래스 만들기

public class StuBubbleSort { // 버블정렬을 수행하는 클래스를 만들어 보도록 하자 ( 메소드만 사용할 것이므로 static으로 작성 )
	private static boolean compare(double score1, double score2) { // 두 학생의 점수를 비교함
		return ( score1 < score2 ); // 작으면 참
	}
	
	private static void swap(StudentInfo[] student,  int min, int max) { // 두 학생의 점수를 교환함
		StudentInfo temp = student[min];
		student[min] = student[max];
		student[max] = temp;
	}
	
	public static void bubblesort(StudentInfo[] student) { // 버블솔트를 수행함 ( 외부에서 사용하므로 접근지정 public )
		int total = student.length; // 배열의 개수
		boolean bubbleFlag = true; // 불필요한 연산을 줄이기 위해서 flag를 설정함
		
		for(int i = ( total - 1 ); i > 0; i--) { // 제일 작은 숫자를 끝으로 보낼 것임
			for(int j = 0; j < i; j++) {
				if(compare(student[j].getScore(), student[j + 1].getScore())) { // 원소가 작은 것을 오른쪽으로 보냄
					swap(student, j, j+1); // 계속 스왑해줌
					bubbleFlag = false; // 교환이 이루어 질때마다 false로 바꿔줌
				}
			}
			
			if(bubbleFlag == true) { // 한 번도 교환이 이루어지지 않았다면
				return; // 그 때는 함수를 끝내버림
			}
		}
	}
}
