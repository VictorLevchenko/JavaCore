package w3_1;import scannerUtil.NumberScanner;

/**26. Даны два целых числа: D (день) и M (месяц), определяющие
 *  правильную дату. Вывести знак Зодиака, соответствующий этой дате:
 *   «Водолей» (20.1–18.2), «Рыбы» (19.2–20.3), «Овен» (21.3–19.4), 
 *   «Телец» (20.4–20.5), «Близнецы» (21.5–21.6), «Рак» (22.6–22.7),
 *    «Лев» (23.7–22.8), «Дева» (23.8–22.9), «Весы» (23.9–22.10),
 *     «Скорпион» (23.10–22.11), «Стрелец» (23.11–21.12),
 *      «Козерог» (22.12–19.1).
 * @author victor
 *
 */
public class Task26 {
	public static String toZodiac (int day, int month) {
		final String[] ZODIAC = {"Водолей", "Рыбы", "Овен", "Телец", "Близнецы",
				"Рак", "Лев", "Дева", "Весы", "Скорпион", "Стрелец", "Козерог"};
		final int[][] LOW_DATE = {{20, 1}, {19, 2}, {21, 3}, {20, 4}, {21, 5},
				{22, 6}, {23, 7}, {23, 8}, {23, 9}, {23, 10}, {23, 11}, {22, 12}};
		final int [][] HIGH_DATE = {{18, 2}, {20, 3}, {19, 4}, {20, 5}, {21, 6},
				{22, 7}, {22, 8}, {22, 9}, {22, 10}, {22, 11}, {21, 12}, {19, 1}};
		for(int i = 0; i < ZODIAC.length-1; i++ ) {
			if ( (day >= LOW_DATE[i][0]) && (month == LOW_DATE[i][1]) ||
					(day <= HIGH_DATE[i][0]) && (month == HIGH_DATE[i][1]))
						return ZODIAC[i];
		}
		return null;
	}
	public static void main(String[] args) {
		int day = 0, month = 0;
		System.out.println("Введите дату рождения");
		day = NumberScanner.input(day, "День: ");
		month = NumberScanner.input(month, "Месяц: ");
		System.out.println(toZodiac(day, month));
		
	}

}
