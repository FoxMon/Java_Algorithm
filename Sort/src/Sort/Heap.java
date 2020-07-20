package Sort;
import java.lang.Comparable;

public class Heap {
	public static void heapSort(Comparable[] a, int heapSize) {
		int size = heapSize - 1;
		
		buildHeap(a, size);
		
		for(int i = size; i > 1; i--) {
			swap(a, 1, i);
			heapify(a, 1, i - 1);
		}
	}
	
	private static void buildHeap(Comparable[] a, int heapSize) {
		for(int i = heapSize/2; i > 1; i--) {
			heapify(a, i, heapSize);
		}
	}
	
	private static void heapify(Comparable[] a, int parent, int heapSize) {
		int left = 2*parent;
		int right = 2*parent + 1;
		int smaller;
		
		if(right <= heapSize) {
			if(isless(a[left], a[right])) {
				smaller = left;
			} else {
				smaller = right;
			}
		} else if(left <= heapSize) {
			smaller = left;
		} else {
			return;
		}
		
		if(isless(a[smaller], a[parent])) {
			swap(a, smaller, parent);
			heapify(a, smaller, heapSize);
		}
	}
	
	private static boolean isless(Comparable u, Comparable v) {
		return ( u.compareTo(v) < 0 );
	}
	
	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}