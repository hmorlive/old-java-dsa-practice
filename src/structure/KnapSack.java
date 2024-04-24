package structure;

import java.util.Arrays;
import java.util.Collections;

public class KnapSack {
	public int[] greedySack(int[][] items, int capacity){
		int[] itemSeq = new int[items.length];
		int count = 0;
		double[] ratio = new double[items.length];
		for (int i = 0; i < items.length; i++) {
			ratio[i] = (double)(items[i][2]) / (items[i][1]);
		}
		Arrays.sort(ratio);
		for (int i = ratio.length - 1; i >= 0; i--) {
			if (capacity >= items[i][1]) {
				capacity -= items[i][1];
				itemSeq[count++] = items[i][0];
			}
		}
		return itemSeq;
	}
}
