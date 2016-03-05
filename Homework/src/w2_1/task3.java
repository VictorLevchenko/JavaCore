package w2_1;



public class task3 {

	public static void main(String[] args) {
		/**3. Даны переменные A, B, C. Изменить их значения, переместив содержимое
		 *  A в C, C — в B, B — в A, и вывести новые значения переменных A, B, C.
		 */
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		
		System.out.println("a = " + a + " b = " + b + " c = " + c);
		int buf = c;
		c = a; a = b; b = buf;
		System.out.println("a = " + a + " b = " + b + " c = " + c);
	}

}
