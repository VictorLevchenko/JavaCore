package w3_1;

import scannerUtil.NumberScanner;

/**23. Мастям игральных карт присвоены порядковые номера:
 *  1 — пики, 2 — трефы, 3 — бубны, 4 — червы. Достоинству карт,
 *   старших десятки, присвоены номера: 11 — валет, 12 — дама, 
 *   13 — король, 14 — туз. Даны два целых числа: N — достоинство 
 *   (6 ≤ N ≤ 14) и M — масть карты (1 ≤ M ≤ 4). Вывести название 
 *   соответствующей карты вида «шестерка бубен», «дама червей», «туз треф» и т. п.
 * @author victor
 */
public class Task23 {
	static final String[] SUITS = {"Spades", "Clubs", " Diamonds", "Hearts"};
	static final String[] CARD_NUMBER = {"six", "seven", "eight", "nine", "ten",
			"Jack", "Queen", "King", "Ace"};
	
	public static void main(String[] args) {
		int a = 0, b = 0;
		a = NumberScanner.input(a, "Input cards number: ");
		b = NumberScanner.input(b, "Input suits number: ");
		System.out.println("You entered: " + CARD_NUMBER[a-6] + 
				 " of " + SUITS[b-1]);

	}

}
