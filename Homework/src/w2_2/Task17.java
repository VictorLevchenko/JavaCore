package w2_2;

import scannerUtil.NumberScanner;

/**17. Дано четырехзначное число. Проверить истинность высказывания: 
 * «Данное число читается одинаково слева направо и справа налево» 
 * (т.е. является палиндромом)
 * @author victor
 */
public class Task17 {
	//only for 4 digit numbers
	static boolean isPalindrom (int n) {
		int[] dig = new int[4];
		for(int i = 0; i < 4; i ++) {
			dig[i] = n % 10;
			n /= 10;
		}
		return ((dig[0] == dig[3]) && (dig[1] == dig[2]) ?
				true : false);
	}
	public static void main(String[] args) {
		int num = 0, counter = 0;
		num = NumberScanner.input(num, "Input positiv 4-digit number ");
		System.out.println(isPalindrom(num));
		for(int i = 1000; i <= 9999; i++) {
			if(isPalindrom(i))
				counter++;
		}
		System.out.println("In the range 1000...9999 there are " +
				counter + " palindroms");
	}

}
