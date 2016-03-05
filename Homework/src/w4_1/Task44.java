package w4_1;

import java.util.*;

/*44. Дано целое число N и массив из N целых чисел, упорядоченный
 *  по возрастанию. Данный набор может содержать одинаковые 
 *  элементы. Вывести в том же порядке все различные элементы
 *   данного массива.
 */
public class Task44 {
	//first variant
	/*public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 4, 5, 6, 6, 7, 7, 7};
		int prev = -1;
		for(int i = 0; i < array.length; i ++) {
			if (array[i] != prev) {
					System.out.print(array[i] + " ");
					prev = array[i];
			}
				
		}
	 */
	//second variant
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 3, 4, 5, 6, 6, 7, 7, 7};
		 TreeSet<Integer> arraySet = new TreeSet<>(Arrays.asList(array));
		for (int a: arraySet)
			System.out.print(a + " ");
	}
}