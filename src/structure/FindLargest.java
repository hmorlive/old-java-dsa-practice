package structure;

import java.util.Arrays;
import java.util.Collections;

public class FindLargest {
	public int[] seek(int[] arr, int k) {
		int[] larNums = new int[k + 1];
		int count = 1, bigger = 0, previous = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			bigger = arr[i] < arr [i+1] ? arr[i+1] : arr[i];
			if (previous == bigger) continue;
			previous = bigger;
			if (larNums[k - 1] == 0) {
				larNums[count] = bigger;
				count++;
				continue;
			}
			larNums[0] = bigger;
			Arrays.sort(larNums);
		}
		return larNums;
	}
}
