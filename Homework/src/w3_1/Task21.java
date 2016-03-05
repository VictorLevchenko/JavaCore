package w3_1;
import scannerUtil.NumberScanner;
/**21. Дан номер года (положительное целое число). Определить 
 * количество дней в этом году, учитывая, что обычный год насчитывает
 *  365 дней, а ви-сокосный — 366 дней. Високосным считается год, 
 *  делящийся на 4, за исключением тех годов, которые делятся на 100
 *   и не делятся на 400 (например, годы 300, 1300 и 1900 не являются
 *    високосными, а 1200 и 2000 — являются).
 * @author victor
 *
 */
public class Task21 {
	
	public static void main(String[] args) {
		//A -divided by 4, C - divided by 100, D - divided by 400
		//leap year = A & !(B & !C) = A & (!B | C)
		int y = 0;
		y = NumberScanner.input(y, "Input year ");
		System.out.print("The year " + y + " has ");
		System.out.println((((y % 4 == 0) & ((y % 100 != 0) | (y % 400 == 0))) ?
				" 366" : "365") + " days");
	}

}
