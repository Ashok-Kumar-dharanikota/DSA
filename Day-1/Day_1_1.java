import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findSecondLargest(int n, int[] arr) {
		// Write your code here.

		int largestNum = arr[0];
		int sLargestNum = Integer.MIN_VALUE;

		for(int i=1; i<arr.length; i++) {
			if(largestNum < arr[i]) {
				sLargestNum = largestNum;
				largestNum = arr[i];
			}
			else if(arr[i] != largestNum && sLargestNum < arr[i]) {
				sLargestNum = arr[i];
			}
		}


		return sLargestNum == Integer.MIN_VALUE ? -1 : sLargestNum;
	}
}