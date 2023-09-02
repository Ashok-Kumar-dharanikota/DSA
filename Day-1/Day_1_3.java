import java.util.* ;
import java.io.*; 
public class Solution {
	public static boolean isPossible(int[] arr, int n) {
		// Write your code here.
		int count = 0;

		for(int i=1; i< arr.length && count <=1; i++) {

			if(arr[i-1] > arr[i]) {
				count++;

				if(i-2<0 || arr[i-2] <= arr[i]) {
					arr[i-1] = arr[i];
				}
				else {
					arr[i] = arr[i-1];
				}


				if(count>1) {
					return false;
				}
			}
		}

		return count <=1;

	}
}