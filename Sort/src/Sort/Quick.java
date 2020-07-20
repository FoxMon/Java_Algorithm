package Sort;
import java.lang.Comparable;

public class Quick {
	public static void quickSort(Comparable[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private static void quickSort(Comparable[] a, int low, int high) {
		if(high <= low) {
			return;
		}
		
		int j = partition(a, low, high);
		
		quickSort(a, low, j - 1);
		quickSort(a, j + 1, high);
	}
	
	private static int partition(Comparable[] a, int start, int last) {
		Comparable stand = a[last];
		int i = start - 1;
		
		for(int j = start; j < last; j++) {
			if(isless(a[j], stand)) {
				swap(a, ++i, j);
			}
		}
		
		swap(a, (i+1), last);
		
		return (i + 1);
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