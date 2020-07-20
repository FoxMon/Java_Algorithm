package Sort;
import java.lang.Comparable;

public class Merge {
	public static void mergeSort(Comparable[] a) {
		Comparable[] b = new Comparable[a.length];
		
		mergeSort(a, b, 0, a.length);
	}
	
	private static void mergeSort(Comparable[] a, Comparable[] b, int low, int high) {
		if(high <= low) {
			return;
		}
		
		int mid = low + (high - low) / 2;
		
		mergeSort(a, b, low, mid);
		mergeSort(a, b, mid + 1, high);
		merge(a, b, low, mid, high);
	}
	
	private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		
		for(int k = low; k <= high; k++) {
			if(i > mid) {
				b[k] = a[j++];
			} else if(j > high) {
				b[k] = a[i++];
			} else if(isless(a[j], a[i])) {
				b[k] = a[j++];
			} else {
				b[k] = a[i++];
			}
		}
		
		for(int k = low; k <= high; k++) {
			a[k] = b[k]; 
		}
	}
	
	private static boolean isless(Comparable u, Comparable v) {
		return ( u.compareTo(v) < 0 );
	}
}