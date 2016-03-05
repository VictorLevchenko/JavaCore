package w2_1;



public class Task7 {
	public static final String USAGE = "ERROR: Input temperature should have "
			+ "decimal point delimiter, not comma!";
	public static void main(String[] args) {
		/** 7. Дано значение температуры T в градусах Цельсия. Определить
		 *  значение этой же температуры в градусах Фаренгейта. Температура
		 *   по Цельсию TC и температура по Фаренгейту TF связаны следующим 
		 *   соотношением: TC=(TF–32)·5/9. Ввод температуры организовать через 
		 *   параметры командной строки.
		 */
		double tC = 0;
		try {
				tC = Double.parseDouble(args[0]);
		} catch (RuntimeException e) {
			System.out.println(USAGE);
			return;
		}
		double tF = (tC * 9 / 5) + 32;
		System.out.println("T(Celsius) = " + tC + "\n"
				+ "T(Fahrenheit) = " + tF);
	}
}
