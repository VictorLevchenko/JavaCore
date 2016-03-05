package w3_2;

import scannerUtil.NumberScanner;

/*33. Начальный вклад в банке равен 1000 руб. Через каждый месяц
 *  размер вклада увеличивается на P процентов от имеющейся суммы 
 *  (P — вещественное число, 0 < P < 25). По данному P определить,
 *   через сколько месяцев размер вклада превысит 1100 руб., и
 *    вывести найденное количество месяцев K (целое число) и 
 *    итоговый размер вклада S (вещественное число).
 */
public class Task33 {
	static int findMonthesToRaseAccount(double startAccount, double finalAccount,
			double monthRate) {
		int m = 0;
		double account = startAccount;
		while(true) {
			m ++;
			account += (account * monthRate / 100);
			if(account > finalAccount)
			return m;
		}
	}
	static double calculateAccount(double startAccount, double monthRate,
			int month) {
		double account = startAccount;
		for(int i = 0; i < month; i ++) {
			account += (account * monthRate / 100);
		}
		int result = (int) Math.round(account * 100);
		return (result / 100);
	}
	public static void main(String[] args) {
		double startAccount = 0;
		double rate = 0;
		double finalAccount = 0;
		int m = 0;
		startAccount = NumberScanner.input(startAccount, 
				"Input inithial account : ");
		rate = NumberScanner.input(rate, "Input rate : ");
		finalAccount = NumberScanner.input(finalAccount,
				"How many money do you want on your account(more than)? : ");
		m = findMonthesToRaseAccount(startAccount, finalAccount, rate);
		System.out.println("You have to wait " + m + " monthes");
		System.out.println("Actual value will be " + 
				calculateAccount(startAccount, rate, m));
		
		
	}

}
