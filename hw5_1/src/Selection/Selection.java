package Selection;

// Selection.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-17
// 평균 선형 시간 선택 알고리즘을 수행하는 클래스를 만들어 보도록 하자

public class Selection { // 평균 선형시간 선택 알고리즘
	public static int select(int ranArr[], int start, int last, int target) { // i 번째 작은 원소를 찾음
		if(start == last) { // 원소가 하나인 경우
			return ranArr[start];
		}
		
		int part = partition(ranArr, start, last); // 분할한 위치의 인덱스
		int sel = part - start + 1; // 기준 원소의  전체 개수에서의 순서
		
		if(target < sel) { // 왼쪽 그룹의 범위 축소
			return select(ranArr, start, part - 1, target);
		} else if (target == sel) { // 찾았을 경우
			return ranArr[part];
		} else { // 오른쪽 그룹의 범위 축소
			return select(ranArr, part + 1, last, target - sel);
		}
	}
	
	private static int partition(int ranArr[], int start, int last) { // 피벗을 중심으로 왼쪽 오른쪽 분할
		int stand = ranArr[last]; // 기준 원소
		int i = start - 1; // i는 1구역 끝지점
		
		for(int j = start; j <= last; j++) { // j는 3구역 시작지점
			if(ranArr[j] < stand) {
				i++;
				swap(ranArr, i, j);
			}
		}
		
		swap(ranArr, i + 1, last); // 기주누언소와 2구역 첫 원소 교환
		
		return i + 1;
	}
	
	private static boolean compare(int comp1, int comp2) { // 단순 두 수를 비교
		return ( comp1 < comp2 );
	}
	
	private static void swap(int ranArr[], int i, int j) { // 단순 두 수를 교환
		int temp = ranArr[i];
		ranArr[i] = ranArr[j];
		ranArr[j] = temp;
	}
}
