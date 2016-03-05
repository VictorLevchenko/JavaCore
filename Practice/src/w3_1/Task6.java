package w3_1;

import java.util.Arrays;
import java.util.Random;

/*2 Найти элемент массива, значение которого находится ближе всего к 
 *среднему значению максимального и минимального элементов массива.
 */
public class Task6 {
	
	static int findClosest(int[] array, float origin) {
		float dif = Float.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < array.length; i ++) {
			if (Math.abs(array[i] - origin) < dif) {
				dif = Math.abs(array[i] - origin);
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[10];
		for(int i = 0; i < array.length; i ++) {
			array[i] = rand.nextInt(20);
		}
		System.out.println(Arrays.toString(array));
		float average = (float)(array[Task5.findMin(array)] + array[Task5.findMax(array)]) / 2;
		int index = findClosest(array, average);
		System.out.println("The closest element to average = " + average);
		System.out.println("Array[" + index + "] = " + array[index]);
	}

}
