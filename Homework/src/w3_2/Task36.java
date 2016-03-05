package w3_2;

import scannerUtil.NumberScanner;

/*36. Дано целое число N (> 1). Последовательность чисел Фибоначчи
 *  FK определяется следующим образом: F1 = 1, F2 = 1, FK = FK–2 + FK–1,
 *   K = 3, 4, … . Проверить, является ли число N числом Фибоначчи.
 *    Если является, то вывести True, если нет — вывести False.
 */
public class Task36 {
	static boolean testFibonacci(int n) {
		int prev_2 = 1;
		int prev_1 = 1;
		int next = 0;
		while(true) {
			//generate next fibonacci
			next = prev_1 + prev_2;
			if(next > n) return false;
			if(next == n) return true;
			prev_2 = prev_1;
			prev_1 = next;
		}
	}
	public static void main(String[] args) {
		int n = 0;
		n = NumberScanner.input(n, "Input a number: ");
		System.out.println(testFibonacci(n));

	}

}
