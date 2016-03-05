package w2_2;
import scannerUtil.NumberScanner;
/**15. Дано целое положительное число. Проверить истинность
 *  высказывания: «Данное число является нечетным трехзначным».
 * @author victor
 *
 */
public class Task15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		a = NumberScanner.input(a, "Input positiv whole number: ");
		System.out.println(((a %2 == 1) && (a > 99) && (a < 1000)) ?
				"true" : "false");

	}

}
