package w3_1;

import scannerUtil.NumberScanner;

/**22. Дан номер месяца — целое число в диапазоне 1–12 
 * (1 — январь, 2 — февраль и т. д.). Вывести название 
 * соответствующего времени года и месяца, например, 
 * “март - весна”, “август - лето” и т.п.
 * @author victor
 *
 */
public class Task22 {
	public static String getMonthName(int i) {
		String[] MONTHS = {"January", "Febrary", "March", "April", "May","June",
			"July", "August", "September", "October", "November", "December"};
		if ((i > 0) && (i < 13)) return MONTHS[i-1];
		else return null;
	}
	public static String getSeasonName(int i) {
		String[] SEASONS = {"Winter", "Spring", "Summer", "Autumn"};
		if(((i > 0) && (i < 3)) || (i == 12)) return SEASONS[0];
		else if((i > 2) && (i < 6)) return SEASONS[1];
		else if ((i > 5) && (i < 9)) return SEASONS[2];
		else if ((i > 8) && (i < 12)) return SEASONS[3];
		return null;
	}
	
	public static void main(String[] args) {
		int m = 0;
		m = NumberScanner.input(m, "Input month's number: ");
		System.out.println(getMonthName(m) + " - " + 
				getSeasonName(m));
		// test
		//for(int i = 1; i < 13; i++)
		//	System.out.println(getMonthName(i) + " - " + 
			//		getSeasonName(i));
	}

}
