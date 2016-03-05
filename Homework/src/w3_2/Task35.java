package w3_2;

import scannerUtil.NumberScanner;

/*35. Дано целое число N (> 1). Если оно является простым,
 *  то есть не имеет положительных делителей, кроме 1 и самого себя,
 *   то вывести True, иначе вывести False.
 */
public class Task35 {
	static boolean testForPrimeNumber(int n) {
		for(int i = 2; i < (n / 2); i ++) {
			if((n % i) == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int n = 0;
		n = NumberScanner.input(n, "Input a number: ");
		System.out.println(testForPrimeNumber(n));

	}

}
