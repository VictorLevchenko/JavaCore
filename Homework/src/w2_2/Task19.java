package w2_2;

import scannerUtil.NumberScanner;

/**19. Даны координаты двух различных полей шахматной доски x1, y1, x2, y2 
 * (целые числа, лежащие в диапазоне 1–8). Проверить истинность высказывания:
 *  «Ладья за один ход может перейти с одного поля на другое».
 * @author victor
 *
 */
public class Task19 {

	public static void main(String[] args) {
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		System.out.println("All coordinate on chess board are [1...8]");
		x1 = NumberScanner.input(x1, " Input x1: ");
		y1 = NumberScanner.input(y1, " Input y1: ");
		x2 = NumberScanner.input(x2, " Input x2: ");
		y2 = NumberScanner.input(y2, " Input y2: ");
		System.out.println((x1 == x2) || (y1 == y2));
		
	}

}
