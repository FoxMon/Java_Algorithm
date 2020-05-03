package Shape;
import java.lang.Comparable;

// ShapeSort.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-09
// 병합정렬을 수행하는 클래스를 만들어 보도록 하자

public class ShapeSort {
	public static void seperate(Shape[] shapeArr) { // 배열을 반반 나누는 것을 수행하는 메소드
		Shape[] temp = new Shape[shapeArr.length]; // 임시배열객체를 생성함
		
		seperate(shapeArr, temp, 0, shapeArr.length - 1); // 반반씩 나누기 위해 sort 함수를 호출함
	}
	
	private static void seperate(Shape[] shapeArr, Shape[] temp, int low, int high) { // 배열을 반반 나누는 메소드 오버로딩
		if(high <= low) { // 종료조건
			return;
		}
		
		int mid = low + (high - low) / 2; // 중간 Index 결정
		
		seperate(shapeArr, temp, low, mid); // 반반 나눠서 수행함. ( 재귀적으로 계속 호출함 )
		seperate(shapeArr, temp, mid+1, high); // 뒷부분도 반반 나눠서 수행함
		merge(shapeArr, temp, low, high);
	}

	private static void merge(Shape[] shapeArr, Shape[] temp, int low, int high) { // 반반 나눈 부분들을 합병함
		int i = low;
		int mid = low + (high - low) / 2;
		int j = mid + 1;
		
		for(int k = low; k <= high; k++) {
			if(i > mid) { // 앞부분 먼저 없어졌다면
				temp[k] = shapeArr[j++];
			} else if(j > high) { // 뒷 부분이 없어졌다면
				temp[k] = shapeArr[i++];
			} else if(compare(shapeArr[j], shapeArr[i])) { // 중간 뒷 부분이 더 작은 경우
				temp[k] = shapeArr[j++];
			} else {
				temp[k] = shapeArr[i++]; // low 부분이 더 작은 경우
			}
 		}
		
		for(int k = low; k <= high; k++) { // 원래의 배열에 임시배열을 대입함
			shapeArr[k] = temp[k];
		}
	}
	
	private static boolean compare(Shape comp1, Shape comp2 ) { // 두 객체의 면적을 비교
		return ( comp1.getArea() < comp2.getArea() );
	}
}
