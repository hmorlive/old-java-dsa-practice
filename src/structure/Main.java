package structure;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	/*
	 * Sends requests to priority queue where they are compared based on priority
	 * @author: Hazmed - with help from research
	 */
	public static void main(String[] args) {
	    //dummy requests (id, priority)
		int[][] req ={{1001,9},{1002,1},{1003,5},{1004,4},{1005,7}};
	    
	    PriorityQueue<int[]> reqQueue = new PriorityQueue<>((x, y) -> {
	        if(x[1] != y[1]) {
	            return Integer.compare(x[1], y[1]);
	        }

	        return 0;
	    });
	    reqQueue.addAll(Arrays.asList(req));
	    while(reqQueue.peek() != null) {
	        System.out.println(Arrays.toString(reqQueue.poll()));
	    }
	}

}
