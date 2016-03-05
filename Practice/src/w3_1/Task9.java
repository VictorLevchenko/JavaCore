package w3_1;

import java.util.Arrays;
import java.util.Random;

//5. Перетасовать массив.
public class Task9 {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[10];
		for(int i = 0; i < array.length; i ++) {
			array[i] = rand.nextInt(20);
		}
		System.out.println(Arrays.toString(array));
		Task2.shuffleArray(array);
		System.out.println(Arrays.toString(array));
	}

}
