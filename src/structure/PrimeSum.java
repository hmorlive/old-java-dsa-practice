package structure;

/**
* * @author hazmed
* @version 1.0
*/

//Calculates the sum of all prime numbers before n
public class PrimeSum {
		
	public void add() {
		calc(120);
	}
	
	public void calc(int num) {
		System.out.println("For prime numbers <= " + num);
		int sum = 0;
		boolean prime = false;
		
		for (int target = num; target > 1; target--) {
			prime = true;
			for (int check = 2; check < target; check++) {
				if (target % check == 0) {
					prime = false;
					break;
				}
			}
			if (prime) sum += target;
		}
		System.out.println("---\nThe final sum is | " + sum + " |");
	}
}
