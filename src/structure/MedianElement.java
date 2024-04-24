package structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hazmed
 * @version 1.0
 * Finds median element of union of 2 sorted lists.
 */
public class MedianElement {
	List<Integer> list1 = new ArrayList<>();  
	List<Integer> list2 = new ArrayList<>();
	List<Integer> unionList = new ArrayList<>();
	//Constructor
	public MedianElement(){
		for (int i = 2; i < 16; i = i+3) list1.add(i);
		for (int i = 4; i < 15; i = i+5) list2.add(i);
		unionList.addAll(list1);
		unionList.addAll(list2);
		Collections.sort(unionList); //sorting union of list
	}
	//Runs the program
	public void run() {
		System.out.println("List 1: " +list2.toString()
				           + "\nList 2: " + list1.toString()
				           + "\nUnion: " + unionList);
		System.out.println(getMedian(list2, list1));		
	}
	
	/**
	 * Gets the median element of two lists
	 * @param list1 
	 * @param list 2
	 * @return
	 */
	float getMedian(List<Integer> l1, List<Integer> l2) {
		int s1 = l1.size(), s2 = l2.size(); //getting sizes of both lists
		float m1 = median(l1), m2 = median(l2); //getting medians of both lists
		List<Integer> newL1 = new ArrayList<>();
		List<Integer> newL2 = new ArrayList<>();
		
		if (m1 == m2) return m1;		
		if (s1 == 1) {
			if (s2 == 1) return m1;
			return getMedian(l1, l2);
		}		
		if (m1 > m2) {
			for (int i = s2/2; i < s2; i++) newL2.add(l2.get(i));
			for (int i = 0; i <= s1/2; i++) newL1.add(l1.get(i));
			System.out.println(newL1.toString() + newL2.toString());
		}
		return getMedian(newL1, newL2);
	}
	
	/**
	 * Finds median element
	 * @return - returns avg of two mid elements
	 */
	float avgMed(int a, int b){
		float avg = a + b;
		avg = avg / 2;
		return avg;
	}
	
	float median(List<Integer> list1) {
		int size = list1.size();
		float median = 0, avg = 0;
		if (size % 2 != 0) return list1.get(size/2);
		median = (list1.get(size/2) + list1.get(size/2 - 1));
		median = median / 2;
		return median;
	}
}
