package w3_2;

import scannerUtil.NumberScanner;

/*34. Дано целое число N (> 0). Используя операции деления нацело
 *  и взятия остатка от деления, вывести все его цифры, начиная 
 *  с самой правой (разряда единиц).
 */
public class Task34 {
	static void printDigits(int n) {
		while(n > 0) {
			System.out.println(n % 10);
			n /= 10;
		}
	}
	public static void main(String[] args) {
		int n = 0;
		n = NumberScanner.input(n, "Input a number: ");
		printDigits(n);

	}

}
