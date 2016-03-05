package w3_1;

import java.util.*;
//1 Поменять местами максимальный и минимальный элемент массива

public class Task5 {
	//return index of min element in the array
	public static int findMin(int[] array) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < array.length; i ++) {
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
		
	}
	//return index of max element in the array
	public static int findMax(int[] array) {
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < array.length; i ++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	//swap elements array[i1] with array[i2]
	public static void swap(int[] array,int i1, int i2) {
		int a = 0;
		a = array[i1];
		array[i1] = array[i2];
		array[i2] = a;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[10];
		for(int i = 0; i < array.length; i ++) {
			array[i] = rand.nextInt(20);
		}
		System.out.println(Arrays.toString(array));
		swap(array, findMax(array), 
				findMin(array));
		System.out.println(Arrays.toString(array));

	}

}
