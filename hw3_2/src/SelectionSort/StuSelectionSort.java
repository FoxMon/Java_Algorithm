package SelectionSort;

// StuSelectionSort.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-01
// 학생의 이름 정보를 오름차순으로 정렬하는 선택정렬 클래스 만들기

public class StuSelectionSort { // 선택정렬을 수행하는 클래스 ( 객체를 생성할 목적이 아니라, 메소드들만 이용하는 것이 목적이기에 static으로 작성 )
	private static boolean compare(String name1, String name2 ) { // 두 학생의 이름을 비교함
		return ( name1.compareTo(name2) < 0 ); // name1의 이름이 사전에 먼저 오는 경우, 참
	}
	
	private static void swap(StudentInfo[] student, int min, int max) { // 두 원소를 교환함
		StudentInfo info = student[min];
		student[min] = student[max];
		student[max] = info;
	}
	
	public static void selectsort(StudentInfo[] student) { // 학생들의 정보를 넘겨받고, 오름차순 정렬함
		int total = student.length; // 학생의 전체 인원 수
		
		for(int i = total - 1; i >= 0; i--) { // 학생 수 만큼 반복문 수행
			int max = i; // 뒤에서부터 출발함. ( 최대값 찾는 인덱스 )
			
			for(int j = ( max - 1 ); j >= 0; j--) { // 뒤의 인덱스부터 채워줌
				if(compare(student[max].getName(), student[j].getName())) { // 기준으로 잡은 ( 맨 뒤의 값 ) 것과 그 전의 인덱스 비교
					max = j; // 그 전의 값이 더 크면 max의 인덱스를 j로 갱신
				}
			}
			
			swap(student, i, max); // 그리고 마지막 인덱스와 바꿔줌
		}
	}
}
