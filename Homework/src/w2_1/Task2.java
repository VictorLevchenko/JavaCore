package w2_1;



public class Task2 {

	public static void main(String[] args) {
		/** 2. Даны переменные A, B, C. Изменить их значения, переместив содержимое 
		 * A в B, B — в C, C — в A, и вывести новые значения переменных A, B, C.
		 */
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		
		System.out.println("a = " + a + " b = " + b + " c = " + c);
		int buf = c;
		c = b; b = a; a = buf;
		System.out.println("a = " + a + " b = " + b + " c = " + c);
	}
}
