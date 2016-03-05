package w2_2;

import scannerUtil.*;

/**13. С начала суток прошло N секунд (N — целое). Найти количество 
 * полных часов, минут и секунд, прошедших с начала суток.
 * @author victor
 *
 */
public class Task13 {

	public static void main(String[] args)  {
		int n = 0;
		n = NumberScanner.input(n, "Input N ");
		System.out.println("Current time (H:M:S): " + 
			(n / 3600) + " : " + ((n % 3600) / 60) + " : " + (n % 60) );		
	}

}

