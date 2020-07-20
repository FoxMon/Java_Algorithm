package Sort;
import java.lang.Comparable;

public class Selection {
	public static void sort(Comparable[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			
			for(int j = i+1; j < arr.length; j++) {
				if(isless(arr[j], arr[min])) {
					min = j;
				}
			}
			
			swap(arr, i, min);
		}
	}
	
	private static boolean isless(Comparable u, Comparable v) {
		return ( u.compareTo(v) < 0 );
	}
	
	private static void swap(Comparable[] a, int i, int j) {
		
	}
}