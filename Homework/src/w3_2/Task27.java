package w3_2;
import scannerUtil.NumberScanner;
/*27. Даны два целых числа A и B (A < B). Найти сумму всех целых
 *  чисел от A до B включительно.
 */
public class Task27 {
	//sum int from a to b
	static int sumInt(int a, int b) {
		int sum = 0;
		for(int i = a; i <= b; i ++) {
			sum += i;
		}
		return sum;
	}
	public static void main(String[] args) {
		int a = 0, b = 0;
		a = NumberScanner.input(a, " Input a: ");
		b = NumberScanner.input(b, "Input b: ");
		System.out.println("Sum = " + sumInt(a, b));

	}

}
