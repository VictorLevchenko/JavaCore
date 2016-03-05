package w3_2;

import scannerUtil.NumberScanner;

/*29. Даны два целых числа A и B (A < B). Найти сумму квадратов
 *  всех целых чисел от A до B включительно.
 */
public class Task29 {
	static int sumSquareInt(int a, int b) {
		int result =0;
		for(int i = a; i <= b; i ++) {
			result += (i*i);
		}
		return result;
	}
	public static void main(String[] args) {
		int a = 0, b = 0;
		a = NumberScanner.input(a, " Input a: ");
		b = NumberScanner.input(b, "Input b: ");
		System.out.println("Sum of squares = " + sumSquareInt(a, b));

	}

}
