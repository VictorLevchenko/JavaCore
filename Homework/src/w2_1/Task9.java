package w2_1;



public class Task9 {

	public static void main(String[] args) {
		/** 9. Дано двузначное число. Найти сумму и произведение его цифр.
		 */
		int a = Integer.parseInt(args[0]);
		System.out.println("Number = " + a);
		int dig1  = a / 10;
		int dig2 = a % 10;
		System.out.println("The sum of digits = " + (dig1 + dig2));
		System.out.println("The product of digits = " + (dig1 * dig2));
	}
}
