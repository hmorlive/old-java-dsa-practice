package structure;

/**
 * 
 * @author hazmed
 * Finds max contiguous subsequence sum in an array
 */
public class ContiguousSum {
	int [] arr = {-2, 11, -4, 13, -5, 2};
	
	//runs the program
	public void run() {
        System.out.println("The maximum contiguous subsequence sum is: " + maxSum(arr));
    }
	
	
 
	/**
	 *  @param - integer array to find maximum contiguous subsequence sum
	 * 	@return - maximum contiguous subsequence sum
	 */
    static int maxSum(int arr[])
    {
        int size = arr.length;
        int currMax = 0;
        int maxEnds = 0;
 
        for (int i = 0; i < size; i++)
        {
        	maxEnds = maxEnds + arr[i];
        	if (maxEnds < 0) maxEnds = 0;
            if (currMax < maxEnds) currMax = maxEnds;
        }
        return currMax;
    }
}
