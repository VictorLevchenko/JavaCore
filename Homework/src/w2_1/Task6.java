package w2_1;



public class Task6 {
	public static final String USAGE = "ERROR: Input temperature should have "
			+ "decimal point delimiter, not comma!";
	public static void main(String[] args) {
		/** 6. Дано значение температуры T в градусах Фаренгейта. Определить 
		 * значение этой же температуры в градусах Цельсия. Температура по Цельсию 
		 * TC и температура по Фаренгейту TF связаны следующим соотношеним:
		 *  TC=(TF–32)·5/9
		 */
		double tF = 0;
		try {
				tF = Double.parseDouble(args[0]);
		} catch (RuntimeException e) {
			System.out.println(USAGE);
			return;
		}
		double tC = (tF - 32) * 5 / 9;
		System.out.println("T(Fahrenheit) = " + tF + "\n"
				+ "T(Celsius) = " + tC);
	}
}
