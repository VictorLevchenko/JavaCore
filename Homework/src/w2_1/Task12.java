package w2_1;



public class Task12 {

	public static void main(String[] args) {
		/**12. Дано трехзначное число. Найти сумму и произведение его цифр.
		 */
		int a = Integer.parseInt(args[0]);
		System.out.println("Number = " + a);
		int prod = 1;
		int sum = 0;
		int dig = 0;
		while(a > 0) {
			dig = a % 10;
			sum += dig;
			prod *= dig;
			a /= 10;
		}
		System.out.println("The sum of digits = " + sum);
		System.out.println("The product of digits = " + prod);
	}

}
