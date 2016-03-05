package scannerUtil;
import java.io.*;
import java.util.*;
/** Input numbers like int, long, float from console
 *
 * @author victor
 *
 */
public class NumberScanner {
//private static OutputStream out = new PrintStream;
private static PrintStream out = new PrintStream(System.out);
public static void println(Object obj) {
	out.println(obj);
}
public static void print(Object obj) {
	out.print(obj);
}
private static Scanner scan = new Scanner(System.in);

@SuppressWarnings("serial")
private static class WrongInputException extends RuntimeException {
		WrongInputException(String mes) { super(mes); }
		@SuppressWarnings("unused")
		WrongInputException() { this("Not expected type"); }
}
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param var A variable you want to input from console
	 * @param str A string that was printed on console before input
	 * @return inputed value
	 * @throws WrongInputException if you input in wrong format
	 */
	public static <T extends Number > T input(T var, String str) 
			throws WrongInputException {
		System.out.println(str);
		try {
			if (var instanceof Integer )				/// Здесь в условии можно использовать scan.hasNextInt() 
					var = (T)((Integer) scan.nextInt());
			if (var instanceof Float)
					var = (T)((Float)scan.nextFloat());
			if (var instanceof Long)
					var = (T)((Long)scan.nextLong());
			if (var instanceof Double)
				var = (T)((Double)scan.nextDouble());
		} catch (Exception e) {
			throw new WrongInputException("Not" + 
				var.getClass().getSimpleName());
		} finally {
			// should empty scanner buffer				
		}
		return var;
	}
	public static void main(String[] args) {
		//for test
		int a = 0;
		Integer b = 0;
		float c = 0F;
		long d = 0L;
		a = input(a, "Input int");
		System.out.println(a);
		b = input(b, "Input Integer ");
		System.out.println(b);
		c = input(c, "Input float ");
		System.out.println(c);	
		d = input(d, "Input long ");
		System.out.println(d);
	}

}
