package w3_2;

import scannerUtil.NumberScanner;

/*30. Дано вещественное число A и целое число N (> 0).
 *  Используя один цикл, найти значение выражения 
 *  1 – A + A2 – A3 + … + (–1)N·AN. Условный оператор не использовать.
 */
public class Task30 {
	static float polinom (float a, int n) {
		float poly = 0F;
		for(int i = 0; i <= n; i ++) {
			poly += Math.pow(- a, i);
		}
		return poly;
	}
	public static void main(String[] args) {
		float a = 0;
		int n = 0;
		a = NumberScanner.input(a, " Input a: ");
		n = NumberScanner.input(n, "Input n: ");
		System.out.println("Poly = " + polinom(a, n));

	}

}
