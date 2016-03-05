package w2_1;



public class task4 {

	public static void main(String[] args) {
		/**4. Поменять местами содержимое переменных A и B, используя 
		 * только эти две переменные, и вывести новые значения A и B.
		 */
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println("a = " + a + " b = " + b);
		a = a - b;
		b = b + a;
		a = b - a;
		System.out.println("a = " + a + " b = " + b);
	}
}
