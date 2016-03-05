package w3_1;

import java.util.Arrays;
import java.util.Random;

/*Сдвинуть массив вправо (влево) так, чтобы минимальный (максимальный)
*элемент массива оказался первым(последним).
*/
public class Task8 {
	static void shiftRight(int[] array) {
		int length = array.length;
		int a = array[length - 1];
		for(int i = length - 1; i > 0; i --) {
			array[i] = array[i - 1];
		}
		array[0] = a;
	}
	//shift array to the right on n position
	static void shiftRight(int[] array, int n) {
		for(int i = 0; i < n; i ++) {
			shiftRight(array);
		}
	}
	static void shiftLeft(int[] array) {
		int length = array.length;
		int a = array[0];
		for(int i = 1; i < length; i ++) {
			array[i - 1] = array[i];
		}
		array[length - 1] = a;
	}
	static void shiftLeft(int[] array, int n) {
		for(int i = 0; i < n; i ++) {
			shiftLeft(array);
		}
	}
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[10];
		for(int i = 0; i < array.length; i ++) {
			array[i] = rand.nextInt(20);
		}
		System.out.println(Arrays.toString(array));
		
		System.out.println("Minimum first");
		shiftLeft(array, Task5.findMin(array));
		System.out.println(Arrays.toString(array));
		
		System.out.println("Maximum first");
		shiftLeft(array, Task5.findMax(array));
		System.out.println(Arrays.toString(array));
		
		System.out.println("Minimum last");
		shiftRight(array, (array.length - Task5.findMin(array) - 1));
		System.out.println(Arrays.toString(array));
		
		System.out.println("Maximum last");
		shiftRight(array, (array.length - Task5.findMax(array) - 1));
		System.out.println(Arrays.toString(array));
	}

}
