package w2_1;



public class Task11 {

	public static void main(String[] args) {
		/**10. Дано двузначное число. Вывести число, полученное 
		 * при перестановке цифр исходного числа.
		 * 11. Решить предыдущую задачу, не использую никаких
		 *  дополнительных переменных.
		*/
		int a = Integer.parseInt(args[0]);
		System.out.println("Number = " + a);
		System.out.println("Reversed Number = " + ((a % 10) * 10 + a / 10));
	}

}
