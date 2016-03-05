package w2_1;



public class Task5 {

	public static void main(String[] args) {
		/** 5. Дано число A. Вычислить A^8, используя вспомогательную переменную
		 *  и три операции умножения. Для этого последовательно находить A^2, A^4, A^8. Вывести все найденные степени числа A.
		 */
		int a = Integer.parseInt(args[0]);
		long b = a;
		for(int i = 0; i < 3; i++) 
			System.out.println(b *= b);
	}
}
