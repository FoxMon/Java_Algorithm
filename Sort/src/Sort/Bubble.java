package Sort;
import java.lang.Comparable;

public class Bubble {
	public static void bubbleSort(Comparable[] arr) {
		boolean bubbleFlag;
		
		for(int i = arr.length - 1; i > 0; i--) {
			bubbleFlag = true;
			
			for(int j = 0; j < i; j++) {
				if(isless(arr[j + 1], arr[j])) {
					swap(arr, j, j+1);
					bubbleFlag = false;
				}
			}
			
			if(bubbleFlag == true) {
				return;
			}
		}
	}
	
	private static boolean isless(Comparable u, Comparable v) {
		return (u.compareTo(v) < 0);
	}
	
	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}