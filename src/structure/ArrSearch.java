package structure;

import lab.Test;

/**
* * @author hazmed
* @version 1.0
*/

//Find item within array using binary search or interpolation search
public class ArrSearch {
		
	public void find() {
		long startTime, stopTime;
		int[] array = {3, 4, 9, 15, 22, 35, 39, 44, 49, 54, 60};
		int max = array.length - 1;
		int check = 4;
		
		//Performing Binary Search
		startTime = System.nanoTime();
		System.out.println("Position: " + biSearch(array, 0, max, check));
		stopTime = System.nanoTime();
		System.out.println("---\nBinary Search time: " + (stopTime - startTime) + " nanoseconds.");

		/*
		//Performing Interpolation Search
		startTime = System.nanoTime();
		System.out.println("Position: " + inSearch(array, 0, max, check));
		stopTime = System.nanoTime();
		System.out.println("---\nInterpolation Search time: " + (stopTime - startTime) + " nanoseconds.");
		*/
	}
	
	//Binary Search
	public int biSearch(int array[], int min, int max, int check) {
		if (max >= 1) {
			int split = (max + min)/2;
			if (array[split] == check) return split;
			if (array[split] > check) return biSearch(array, min, split - 1, check);
			if (array[split] < check) return biSearch(array, split + 1, max, check);
		}
		return -1;
	}
	
	//Interpolation Search
	public int inSearch(int array[], int min, int max, int check) {
		int guess;
		
		if (min <= max && check >= array[min] && check <= array[max]) {
			guess = min +
					(((max -min) / (array[max] - array[min])) *
					(check - array[min]));
			
			if (array[guess] == check) return guess;
			if (array[guess] < check) return inSearch(array, guess + 1, max, check);
			if (array[guess] > check) return inSearch(array, min, guess - 1, check);
		}
		return -1;
	}
}
