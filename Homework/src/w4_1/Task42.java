package w4_1;

import scannerUtil.NumberScanner;

/*42. Дано целое число K и массив из десяти целых ненулевых
 *  чисел. Вывести номер последнего числа в массиве, большего K.
 *   Если таких чисел нет, то вывести 0.
 */
public class Task42 {

	/* return index of first number greater than k
	 * or -1 if there is no numbers grater than k
	 */
	static int findIndexOfLastGreaterIntInArray(int[] array, int k) {
		int ind = -1;
		for(int i = 0; i < array.length; i ++)
			if (array[i] > k) {
				ind = i;
			}
		return ind;
	}
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int k = 0, ind = 0;
		k = NumberScanner.input(k, " Input k: ");
		 ind = (findIndexOfLastGreaterIntInArray(array, k));
		if(ind >= 0)
		System.out.println("The last number greater than "
				+ k + " has index " + ind);
		else
			System.out.println("There is no number greater than "
					+ k + " in the array");
	}

}
