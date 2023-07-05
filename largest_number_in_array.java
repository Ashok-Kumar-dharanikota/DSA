import java.util.*;

public class findSmallestElement {

  public static void main(String args[]) {

    int[] arr = {4,7,34,21,0,8,3,2,1,78};

    //Using loop
    int large = arr[0];
    for(int i=1; i<arr.length; i++) {
        if(large < arr[i]) {
          large = arr[i];
        }
    }
    System.out.print(large);

    //Using Pre-defined methods of Arrays
    Arrays.sort(arr);
    System.out.println(arr[arr.length - 1]);

  }  
}
