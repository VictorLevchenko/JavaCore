package w2_2;

import scannerUtil.NumberScanner;

/**14. Дни недели пронумерованы следующим образом: 1 — понедельник, 
 * 2 — вторник, …, 6 — суббота, 7 — воскресенье. Дано целое число K, 
 * лежащее в диапазоне 1–365. Определить номер дня недели для K-го дня 
 * года, если известно, что в этом году 1 января было средой.
 * @author victor
 *
 */
public class Task14 {
	private static final String[] DAYS = { "MONDAY", "TUESDAY",
			"WENSDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" };
	public static void main(String[] args) {
		int[] days = new int[365];
		int a = 3, k = 0;
		// fill in the array with day numbers
		for(int i = 0; i < 365; i++) {
			a = (a > 7) ? 1 : a;
			days[i] = a++;
		}
		System.out.println(" Input '0' to stop...");
		while(true) {
			k = NumberScanner.input(k, " Input day of the year number ");
			if (k == 0) return;
			System.out.println("This day is " + DAYS[days[k - 1] - 1]);
		}
	}

}