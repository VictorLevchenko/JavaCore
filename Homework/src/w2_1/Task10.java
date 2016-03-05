package w2_1;



public class Task10 {

	public static void main(String[] args) {
		/**10. Дано двузначное число. Вывести число, полученное при 
		 * перестановке цифр исходного числа.
		 */
		int a = Integer.parseInt(args[0]);
		System.out.println("Number = " + a);
		int dig1  = a / 10;
		int dig2 = a % 10;
		System.out.println("Reversed Number = " + (dig2*10 + dig1));
	}

}
