package Shape;
import java.lang.Comparable;

// ShapeSort.java
// 201635006 컴퓨터공학과 김준호
// 2020-04-09
// 2020-04-14 heapSort 추가
// 병합, 힙정렬을 수행하는 클래스를 만들어 보도록 하자

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
	
	public static void heapSort(Shape[] shapeArr, int size) { // 힙정렬을 수행함
		int heapSize = size - 1;
		
		buildHeap(shapeArr, heapSize); // 최대힙으로 만듬
		
		for(int i = heapSize ; i > 0; i--) { // 힙정렬 수행
			swap(shapeArr, 0, i); // 최댓값을 맨 뒤로 보내고
			heapify(shapeArr, 0, i - 1); // 하나 감소된 채로 최대힙 만들어줌
		}
	}
	
	private static void buildHeap(Shape[] shapeArr, int heapSize) { // 힙으로 만듬
		for(int i = (heapSize / 2) - 1; i >= 0; i--) { // 리프노드가 아닌 노드의 맨 마지막 노드
			heapify(shapeArr, i, heapSize);
		}
	}
	
	private static void heapify(Shape[] shapeArr, int parent, int heapSize) { // 힙 성질로 만들기
		int left = (parent * 2) + 1; // 왼쪽자식
		int right = (parent * 2) + 2; // 오른쪽자식
		int bigger; // 더 큰 값의 인덱스
		
		// 더 큰 자식을 골라야함
		if(right <= heapSize) { // 두 자식을 가지는 경우
			if(compare(shapeArr[left], shapeArr[right])) {
				bigger = right;
			} else {
				bigger = left;
			}
		} else if(left <= heapSize) { // 하나의 자식만 가지는 경우
			bigger = left;
		} else { // 리프노드인 경우 끝.
			return;
		}
		
		if(compare(shapeArr[parent], shapeArr[bigger])) { // 부모가 더 작다면 bigger와 교환
			swap(shapeArr, parent, bigger);
			heapify(shapeArr, bigger, heapSize); // 재귀적으로 수행
		}
	}
	
	private static void swap(Shape[] shapeArr, int i, int j) { // 두 인덱스의 값들을 교환해줌
		Shape temp = shapeArr[i];
		shapeArr[i] = shapeArr[j];
		shapeArr[j] = temp;
	}
	
	private static boolean compare(Shape comp1, Shape comp2 ) { // 두 객체의 면적을 비교
		return ( comp1.getArea() < comp2.getArea() );
	}
}
