package w3_1;
/*Изменить порядок следования элементов массива на противоположный
 */

import java.util.Arrays;
import java.util.Random;

public class Task7 {
	static void reverse(int[] array) {
		int size = array.length;
		for(int i = 0; i < size / 2; i ++) {
			Task5.swap(array, i, (size - 1 - i));
		}
	}
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[10];
		for(int i = 0; i < array.length; i ++) {
			array[i] = rand.nextInt(20);
		}
		System.out.println(Arrays.toString(array));
		reverse(array);
		System.out.println(Arrays.toString(array));
		
	}

}
