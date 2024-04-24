 package structure;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ScanStack {
	public boolean contains(Stack S, int x) {
		int n = 0;
		Queue<Integer> Q = new PriorityQueue<Integer>();
		boolean exists = false;
		while (!(S.empty())) {
			Q.add((Integer) S.pop());
			n++;
		}
		for (int i = 0; i < n; i++) {
			if (Q.peek() == x) exists = true;
			S.push(Q.remove());
		}
		return exists;
	}
}
