# Coding Ninjas Problem Solutions

## Table of Contents
1. [Second Largest Element in the Array](#second-largest-element-in-the-array)
2. [Rotate Array](#rotate-array)
3. [Non-Decreasing Array](#non-decreasing-array)
4. [Search in Array](#search-in-array)
5. [Check Equality of Two Arrays](check-equality-of-two-arrays)
6. [Find Missing Element in Arithmetic Progression](#find-missing-element-in-arithmetic-progression)
7. [Rotate Array](#rotate-array)
---

## Second Largest Element in the Array
[Problem Link](https://www.codingninjas.com/studio/problems/second-largest-element-in-the-array_873375)

### Hand Trace
Given the array `arr = [2, 7, 4, 3]`
- Initialize `largestNum` as the first element of the array and `sLargestNum` as the smallest possible integer.
- Iterate over the array elements.
  - If we find a number greater than `largestNum`, set `sLargestNum` to `largestNum` and update `largestNum`.
  - Else if the number is different than `largestNum` and greater than `sLargestNum`, update `sLargestNum`.
- If `sLargestNum` remains the smallest integer, return -1. Otherwise, return `sLargestNum`.
- The result for this example would be `4`.

### Code
```java
import java.util.*;
import java.io.*;

public class Solution {
	public static int findSecondLargest(int n, int[] arr) {
		int largestNum = arr[0];
		int sLargestNum = Integer.MIN_VALUE;
		for(int i=1; i<arr.length; i++) {
			if(largestNum < arr[i]) {
				sLargestNum = largestNum;
				largestNum = arr[i];
			} else if(arr[i] != largestNum && sLargestNum < arr[i]) {
				sLargestNum = arr[i];
			}
		}
		return sLargestNum == Integer.MIN_VALUE ? -1 : sLargestNum;
	}
}
```
# Rotate Array

[Problem Link](https://www.codingninjas.com/studio/problems/rotate-array_1230543)

## Hand Trace
For an array `arr = [1, 2, 3, 4, 5]` and rotate count `2`:

- Start by copying the first `rotate` count elements into a new array, `rotArr = [1, 2]`.
- Shift the rest of the elements in `arr` left by `rotate` count.
- Add the elements from `rotArr` to the end of `arr`.
- The final rotated array will look like `[3, 4, 5, 1, 2]`.

## Code
```java
import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) {
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
```
# Non-Decreasing Array

[Problem Link](https://www.codingninjas.com/studio/problems/non-decreasing-array_699920
)

## Hand Trace
For the array `arr = [4, 2, 3]`:

- Start iterating from the second element.
- When the element at position `1` (`arr[1]` which is `2`) is less than the previous element `4`, a modification is required.
- Since there's no element two positions back, or the condition `arr[i-2] <= arr[i]` is true, the element at position `0` (`arr[0]`) is set to `2`.
- The array becomes `[2, 2, 3]`.
- No other modifications are required.
- As only one modification was made, the method would return `true`.

## Code
```java
import java.util.*;
import java.io.*;

public class Solution {
	public static boolean isPossible(int[] arr, int n) {
		int count = 0;
		for(int i=1; i< arr.length && count <=1; i++) {
			if(arr[i-1] > arr[i]) {
				count++;
				if(i-2<0 || arr[i-2] <= arr[i]) {
					arr[i-1] = arr[i];
				} else {
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
```

# Search in Array

[Problem Link](https://practice.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1?page=1&difficulty[]=-1&category[]=Arrays&sortBy=submissions)


## Description
The `Solution` class provides a method to search for an element (`X`) in an array (`arr`). If the element is found, it returns the index of the element; otherwise, it returns `-1`.

## Method
### `search(int arr[], int N, int X)`

#### Parameters:
- `arr[]`: An array of integers.
- `N`: Size of the array.
- `X`: Element to be searched in the array.

#### Returns:
- Index of the element `X` if it's found.
- `-1` if the element is not found.

## Hand Trace
For an array `arr = [5, 8, 3, 6, 9]` and search element `X = 6`:

1. Begin iterating from the first element of the array.
2. Compare the current element with `X`.
3. When `i = 3`, `arr[i]` is `6` which matches `X`.
4. Return `i`, which is `3`.
5. If we iterate through the entire array without finding `X`, return `-1`.

For the above example, the method will return `3`.

## Code
```java
class Solution { 
    static int search(int arr[], int N, int X) {
        for(int i=0; i<N; i++) {
            if(X == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
```
# Check Equality of Two Arrays

[Problem Link](https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1?page=1&difficulty[]=-1&category[]=Arrays&sortBy=submissions)


## Description
The `Solution` class provides a method to check if two arrays `A` and `B` are equal. The method first sorts both arrays and then compares them for equality.

## Method
### `check(long A[], long B[], int N)`

#### Parameters:
- `A[]`: The first array of long integers.
- `B[]`: The second array of long integers.
- `N`: Size of the arrays.

#### Returns:
- `true` if arrays are equal.
- `false` if the arrays are not equal.

## Hand Trace
For two arrays `A = [5, 3, 8]` and `B = [3, 8, 5]`:

1. Begin by sorting both arrays.
2. After sorting, `A` becomes `[3, 5, 8]` and `B` becomes `[3, 5, 8]`.
3. Since both sorted arrays are now identical, the function will return `true`.

If `B` was `[3, 8, 7]`, after sorting, it would become `[3, 7, 8]`, which isn't equal to sorted `A`. Thus, the function would return `false`.

## Code
```java
import java.util.Arrays;

class Solution {
    public static boolean check(long A[], long B[], int N) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        return Arrays.equals(A, B);
    }
}
```

# Find Missing Element in Arithmetic Progression

[Problem Link](https://practice.geeksforgeeks.org/problems/missing-element-of-ap2228/1?page=2&difficulty[]=0&status[]=solved&category[]=Arrays&sortBy=submissions)


## Description
The `Solution` class provides a method that finds the missing number in an arithmetic progression.

## Method
### `findMissing(int[] arr, int n)`

#### Parameters:
- `arr[]`: The array of integers representing the arithmetic progression.
- `n`: Size of the array.

#### Returns:
- The missing number in the arithmetic progression.
- `-1` if no number is missing.

## Hand Trace
For the array `arr = [2, 4, 6, 10, 12]`:

1. Calculate the first term `a = 2` (first element of the array).
2. Determine the common difference `d` of the arithmetic progression using the formula `(last term - first term) / n`. In this case, `(12 - 2) / 5 = 2`.
3. Start iterating through the array.
4. At `i = 3`, the expected number would be `2 + 3*2 = 8`, but `arr[3] = 10`. Hence, the missing number is `8`.

For the provided example, the method will return `8`.

## Code
```java
class Solution {
    int findMissing(int[] arr, int n) {
        int a = arr[0];
        int d = (arr[n-1] - a) / n;
        for(int i = 0; i < n; i++) {
            if((a + i * d) != arr[i]) return (a + i * d);
        }
        return -1;
    }
}
```

# Rotate Array

[Problem Link](https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1?page=1&difficulty[]=-1&category[]=Arrays&sortBy=submissions)


## Description
The `Compute` class provides a method to rotate the elements of an array by one position to the left.

## Method
### `rotate(int[] arr, int n)`

#### Parameters:
- `arr[]`: The array of integers to be rotated.
- `n`: Size of the array.

## Hand Trace
For the array `arr = [1, 2, 3, 4, 5]`:

1. Create a new array `newarr`.
2. Place the last element of `arr` (`arr[n-1]` which is `5`) into the first position of `newarr`, making `newarr = [5, _, _, _, _]`.
3. Copy the rest of the elements from `arr` to `newarr`, offset by one position.
   - After this operation, `newarr` becomes `[5, 1, 2, 3, 4]`.
4. Copy the `newarr` values back to the `arr`.

For the given example, `arr` will be updated to `[5, 1, 2, 3, 4]`.

## Code
```java
class Compute {
    public void rotate(int arr[], int n) {
        int[] newarr = new int[n];
        newarr[0] = arr[n-1];

        for(int i=0; i<n-1; i++) {
            newarr[i+1] = arr[i];
        }
        for(int j=0; j<n; j++) {
            arr[j] = newarr[j];
        }
    }
}
