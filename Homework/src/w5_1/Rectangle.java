package w5_1;

public class Rectangle extends Shape {
	private static int count = 0;
	public final int id = count ++;
	
	private double a, b;
	public Rectangle(double a, double b) {
		setA(a);
		setB(b);
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public static Rectangle create(double a, double b) {
		return new Rectangle(a, b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getArea() {
		return (a * b);
	}

	@Override
	public double getPerimeter() {
		return 2 * (a + b);
	}
	@Override
	public String toString() {
		return ("Rectangle " + id + " with sides " + a + ", " + b);
	}
}
