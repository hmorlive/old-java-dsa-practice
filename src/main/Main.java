package main;
import lab.Test;

/**
* Main
* * @author hazmed
* @version 1.0
*/
public class Main {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Test.run();
		long stopTime = System.nanoTime();
		System.out.println("---\nExecution time: " + (stopTime - startTime) + " nanoseconds.");
	}

}
