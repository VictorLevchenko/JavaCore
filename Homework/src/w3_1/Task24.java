package w3_1;

import scannerUtil.NumberScanner;

/**24. Дано целое число в диапазоне 100–999. Вывести строку-описание 
 * данного числа, например: 256 — «двести пятьдесят шесть», 
 * 814 — «восемьсот четырнадцать».
 * @author victor
 */
public class Task24 {
	public static String convertNumbersToString(int num) {
		final String[] DIGITS = {"one", "two", "three", "four", "five",
				"six", "seven", "eight", "nine"};
		final String[] NUMBERS_10_19 = {"ten", "eleven", "twelve", "thirteen",
			"fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		final String[] TENS_20_90 = {"twenty", "thirty", "forty", "fifty", "sixty",
				"seventy", "eighty", "ninety"};
		int hundr = 0, ones = 0, tens = 0, var = 0;
		String result = new String();
		
		hundr = num / 100;
		ones = num % 10;
		tens = (num % 100) / 10;
		var = num % 100;
		
		result += (DIGITS[hundr-1] + " hundred ");
		if(var !=0)
			result += "and ";
		if ((var > 9) && (var < 20)) {
			result += (NUMBERS_10_19[var-10] + " ");
			return result;
		}
		else if (var > 19) 
			result += (TENS_20_90[tens-2] + " ");
		if(ones != 0)
				result += DIGITS[ones -1];
		
		return result;
	}
	public static void main(String[] args) {
		
		/* test
		for(int i = 100; i < 1000; i++) {
			System.out.println(convertNumbersToString(i));
		}
		*/
		int a = 0;
		a = NumberScanner.input(a, "Enter a number in range(100-999): ");
		System.out.println("You entered " + convertNumbersToString(a));
		
		
	}
		
}
