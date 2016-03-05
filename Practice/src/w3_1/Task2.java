package w3_1;

import java.util.*;

/**Write a code fragment that shuffle one-dimensional
*array a[] of different int values.
*/

public class Task2 {
	private static Random rand = new Random();
/** shuffle array by Knuth algorithm
 * 
 * @param array 
 */
	static void shuffleArray(int[] array) {
		int a = 0, ind = 0;
		for(int i = 0; i < array.length; i ++) {
			a = array[i];
			ind =  i + rand.nextInt(array.length - i);
			array[i] = array[ind];
			array[ind] = a;
		}
	}
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(array));
		shuffleArray(array);
		System.out.println(Arrays.toString(array));
	}

}
