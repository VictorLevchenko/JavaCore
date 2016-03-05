package w4_1;
/*43. Дано вещественное число B, целое число N и массив из N
 *  целых чисел, упорядоченных по возрастанию. Вывести элементы
 *   массива вместе с числом B, сохраняя упорядоченность выводимых чисел.
 */
public class Task43 {

	public static void main(String[] args) {
		double b = 3.5;
		int[] array = { 1, 2, 4, 5, 6};
		boolean flagNotOutput = true;
		for(int i = 0; i < array.length; i ++) {
			if ((b < (double)array[i]) && flagNotOutput) {
					System.out.print(b + " ");
					flagNotOutput ^= true;
					i--;
			} else {
				System.out.print(array[i] + " ");
			}
				
		}

	}

}
