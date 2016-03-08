package w5_1;

public class Circle extends Shape {
	private static int count = 0;
	public final int id = count ++;
	private double r;
	private Circle(double r) {
		this.r = r;
	}
	public static Circle create(double r) {
		Circle c = null;
		if(r > 0) {
			c = new Circle(r);
			
		}
		return c;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public double getArea() {
		return (Math.PI * r * r);
	}
	@Override
	public double getPerimeter() {
		return (Math.PI * 2 * r);
	}
	@Override
	public String toString() {
		return ("Circle " + id + " with radius " + getR());
	}

}
