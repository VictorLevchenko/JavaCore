package w3_2;

import scannerUtil.NumberScanner;

/*31. Дано целое число N (> 0). Найти произведение N! = 1·2·…·N 
 * (N–факториал). Чтобы избежать целочисленного переполнения,
 *  вычислять это произведение с помощью вещественной переменной
 *   и вывести его как вещественное число.
 */
public class Task31 {
	static double factorial(int n) {
		double result = 1;
		for(int i = 1; i <= n; i ++)
			result *= i;
		return result;
	}
	public static void main(String[] args) {
		int n = 0;
		n = NumberScanner.input(n, "Input n: ");
		System.out.println("n! = " + factorial(n));


	}

}
