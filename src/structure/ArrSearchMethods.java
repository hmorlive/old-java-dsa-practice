package structure;

/*
 * @author: Hazmed
 * @version: 1.0
 * 
 * ---
 * 
 * Sorts arrays via:
 * - Selection Sort
 * - Quick Sort
 * - Merge Sort
 */
public class ArrSearchMethods {	
	/*
	 * Runs the program
	 */
	public void run() {
		int targetArr[] = {10, 3, 21, 7, 2, 13, 67, 35, 24, 5, 45,
						   11, 30, 9, 74, 56, 41, 33, 17, 20, 61, 25};
		System.out.println("Unsorted array\n" + arrToString(targetArr) + "\n");
		
		/*
		//Testing selSort()
		selSort(targetArr);
		System.out.println("Selection Sort\n" +
		        			arrToString(targetArr)); 
		*/
		
		/*
		//testing mergeSort
		mergeSort(targetArr, targetArr.length);
		System.out.println("Merge Sort\n" +
					        arrToString(targetArr)); 
		*/
		
		
		//testing quickSort()
		quickSort(targetArr, 0, targetArr.length - 1);
		System.out.println("Quick Sort\n" +
					        arrToString(targetArr));
		
	}
	
	/*
	 * Sorts the array using the Selection Sort Method
	 * @param arr - array to be sorted
	 * @return arr - array
	 */
	private int[] selSort(int[] arr) {
		int size = arr.length;
		
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			
			for (int j = i + 1; j < size; j++) {
				if (arr[j] < arr[min]) min = j;
			}
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	/*
	 * Sorts the left and right subarrays
	 * @param arr - array to be sorted,
	 * @param size - size of array to be sorted
	 * @return arr - array
	 */
	private int[] mergeSort(int[] arr, int size) {
			if (size < 2) return arr;
			
			int mid = size / 2;
			int[] lArr = new int[mid];
			int[] rArr = new int[size - mid];
			
			int j = 0;
			for (int i = 0; i < size; i++) {
				if (i < mid) lArr[i] = arr[i];
				else rArr[j++] = arr[i];
			}
						
			mergeSort(lArr, mid);
			mergeSort(rArr, size - mid);
			
		    merge(arr, lArr, rArr, mid, size - mid);
		    return arr;
	}
	
	/*
	 * Merges the subarrays
	 * @param arr - whole array
	 * @param lArr - left subarray
	 * @param rArr - right subarray
	 * @param lSize - left subarray size
	 * @param rSize - right subarray size
	 * @return arr - array
	 */
	private int[] merge(int[] arr, int[] lArr, int[] rArr, int lSize, int rSize) {		
		int i = 0, l = 0, r = 0;
		
		while (l < lSize && r < rSize) {
			if (lArr[l] < rArr[r]) arr[i++] = lArr[l++];
			else arr[i++] = rArr[r++];			
		}
		
		while (l < lSize) arr[i++] = lArr[l++];
		while (r < rSize) arr[i++] = rArr[r++];
		
		return arr;
	}
	
	/*
	 * Sorts array via quickSort method
	 * @param arr - whole array
	 * @param lPoint - left pointer
	 * @param rPoint - right pointer
	 * @return arr - array
	 */
	private int[] quickSort(int[] arr, int lPoint, int rPoint) {
		if (rPoint > lPoint) {
			int ind = part(arr, lPoint, rPoint);
			
			quickSort(arr, lPoint, ind - 1);
			quickSort(arr, ind + 1, rPoint);
		}
		return arr;
	}
	
	/*
	 * Sorts pivot (right pointer) to corresponding position
	 * @param arr - whole array
	 * @param lPoint - left pointer
	 * @param rPoint - right pointer
	 * @return arr - array
	 */
	private int part(int arr[], int lPoint, int rPoint) {
		int piv = arr[rPoint];
		int i = (lPoint - 1);
		
		for (int j = lPoint; j < rPoint; j++) {
			if (arr[j] <= piv) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i + 1];
		arr[i + 1] = arr[rPoint];
		arr[rPoint] = temp;
		
		return i + 1;
	}
	
	
	
	/*
	 * String Representation of Array
	 * @param arr - array to be turned into string
	 * @return output - string representation of array
	 */
	private String arrToString(int[] arr) {
		String output = "{";
		int size = arr.length;
		
		for (int i = 0; i < size; i++) {
			if (i != (size - 1)) output += arr[i] + ", ";
			else output += arr[i] + "}";	
		}
		return output;
	}
}
