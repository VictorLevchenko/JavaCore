package w3_2;

import scannerUtil.NumberScanner;

/*28. Даны два целых числа A и B (A < B). Найти произведение всех 
 * целых чисел от A до B включительно
 */
public class Task28 {
	static int productInt(int a, int b) {
		int prod = 1;
		for(int i = a; i <= b; i ++) {
			prod *= i;
		}
		return prod;
	}
	public static void main(String[] args) {
		int a = 0, b = 0;
		a = NumberScanner.input(a, " Input a: ");
		b = NumberScanner.input(b, "Input b: ");
		System.out.println("Product = " + productInt(a, b));

	}

}
