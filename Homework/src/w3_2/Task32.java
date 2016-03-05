package w3_2;

import java.util.Arrays;

import scannerUtil.NumberScanner;

/*32. Дано целое число N (> 1). Последовательность чисел Фибоначчи
 *  FK (целого типа) определяется следующим образом: F1 = 1, F2 = 1,
 *   FK = FK–2 + FK–1, K = 3, 4, … . Вывести элементы F1, F2, ..., FN.
 */
public class Task32 {
	static int[] fibonacci( int n) {
		int[] sequence = new int[n];
		sequence[0] = 1;
		sequence[1] = 1;
		for(int i = 2; i < n; i ++) {
			sequence[i] = (sequence[i - 1] + sequence[i - 2]);
		}
		return sequence;
	}
	public static void main(String[] args) {
		int n = 0;
		n = NumberScanner.input(n, "Input n : ");
		int[] fib = fibonacci(n);
		System.out.println("Fibonacci sequence for n = " + n + " \n" + 
				Arrays.toString(fib));

	}

}
