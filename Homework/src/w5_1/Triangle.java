package w5_1;

public class Triangle extends Shape {
	private static int count = 0;
	public final int id = count ++;
	private double a, b , c;
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
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	private Triangle(double a, double b, double c) {
		setA(a);
		setB(b);
		setC(c);
	}
	public static Triangle create(double a, double b, double c) {
		if((a < (b + c)) && (b < (a + c)) && (c < (a + b)))
			return new Triangle(a, b, c);
		else 
			return null;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/** calculate area using Heron formula */
	@Override
	public double getArea() {
		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	@Override
	public double getPerimeter() {
		return (a + b + c);
	}
	
	public String toString() {
		return ("Triangle " + id + " with sides " + a + ", " + b + ", " + c);
	}

}
