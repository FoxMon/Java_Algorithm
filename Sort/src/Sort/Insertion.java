package Sort;
import java.lang.Comparable;

public class Insertion {
	public static void insertionSort(Comparable[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(isless(arr[j], arr[j - 1])) {
					swap(arr, j, j -1);
				}
			}
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