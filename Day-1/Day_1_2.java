import java.util.* ;
import java.io.*; 
class Solution {
	
	public static void main(String args[]) {
		
		// Write code here
		Scanner sc  = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int rotate = sc.nextInt();
		int[] rotArr = new int[rotate];

		for(int i=0; i<rotate; i++){
			rotArr[i] = arr[i];
		}

		int initial = 0;
		while(initial+rotate < n) {
			arr[initial] = arr[initial+rotate];
			initial++;
		}
		
		int rotV = rotate;
		initial = 0;
		while(0 < rotV) {
			arr[n-rotV] = rotArr[initial];
			initial++;
			rotV--;
		}

		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}

	}
}