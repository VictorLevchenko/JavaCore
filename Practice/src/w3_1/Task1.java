package w3_1;

import java.util.*;

/**Write a code fragment that reverses the order of a
* one-dimensional array a[] of int values. Do not
*create another array to hold the result.
*/
public class Task1 {
	static int[] reverseArray(int[] ar) {
		int a = 0;
		for(int i = 0, j = ar.length-1; i < (ar.length/2); i ++, j--) {
			a = ar[i]; ar[i] = ar[j]; ar[j] = a;
		}
		return ar;
	}
	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4, 5, 6};
		int[] array2 = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(reverseArray(array1)));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(reverseArray(array2)));

	}

}
