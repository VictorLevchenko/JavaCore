package w2_2;

import scannerUtil.NumberScanner;

/**16. Дано трехзначное число. Проверить истинность высказывания: «Цифры данного 
 * числа образуют возрастающую последовательность».
 *	a. Проверить истинность высказывания: «Цифры данного числа образуют возрастающую
 *	арифметическую последовательность», например, 123, 456 и т.п.
 */
public class Task16 {

	public static void main(String[] args) {
		
		int num = 0;
		int a = 0, b = 0, c = 0;
		num = NumberScanner.input(num, "Input positiv 3-digit number");
		//num = abc
		a = num / 100;
		b = (num % 100) / 10;
		c = num % 10;
		System.out.println(((c > b) && (b > a)) ? "true" : "false");
		System.out.println(((c - b) == 1) && ((b - a) == 1) ?	/// Арифметическая последовательность может быть и 135 и 258 и 159
				"true" : "false");
	}

}
