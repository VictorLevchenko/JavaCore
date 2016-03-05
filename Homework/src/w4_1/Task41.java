package w4_1;
import static scannerUtil.NumberScanner.*;

/*41. Дано целое число K и массив из десяти целых ненулевых 
 * чисел. Вывести номер первого числа в массиве, большего K.
 *  Если таких чисел нет, то вывести 0.
 */
public class Task41 {
	/* return index of first number greater than k
	 * or -1 if there is no numbers grater than k
	 */
	static int findIndexOfFirstGreaterIntInArray(int[] array, int k) {
		int ind = -1;
		for(int i = 0; i < array.length; i ++)
			if (array[i] > k) {
				ind = i;
				break;
			}
		return ind;
	}
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int k = 0, ind = 0;
		k = input(k, " Input k: ");
		 ind = (findIndexOfFirstGreaterIntInArray(array, k));
		if(ind >= 0)
			println("The first number greater than "
				+ k + " has index " + ind);
		else
			println("There is no number greater than "
					+ k + " in the array");
	}

}
