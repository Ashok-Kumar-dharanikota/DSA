import java.util.*;

public class findSmallestElement {

  public static void main(String args[]) {

    int[] arr = {4,7,34,21,0,8,3,2,1,78};

    //Using loop
    int small = arr[0];
    for(int i=0; i<arr.length; i++) {
        if(small > arr[i]) {
          small = arr[i];
        }
    }
    System.out.print(small);

    //Using Pre-defined methods of Arrays
    Arrays.sort(arr);
    System.out.println(arr[0]);

  }  
}
