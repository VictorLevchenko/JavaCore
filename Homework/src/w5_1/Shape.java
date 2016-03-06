package w5_1;

import java.text.DecimalFormat;
import java.util.*;

public abstract class Shape {
	public abstract double getArea();
	public abstract double getPerimeter();

	public static void main (String[] args) {
		DecimalFormat df = new DecimalFormat("#.0");
		List<Shape> list = new ArrayList<>();
		Shape s = Triangle.create(3, 4, 5);
		if(s != null) list.add(s);
		s = Circle.create(5);
		if(s != null) list.add(s);
		s = Circle.create(10);
		if(s != null) list.add(s);
		s = Rectangle.create(4, 5);
		if(s != null) list.add(s);
		
		//Polymorphism in action!!!
		for(Shape a: list) System.out.println(a + " has area " + df.format(a.getArea()) + 
				" and perimeter " + df.format(a.getPerimeter()));
		
	}
}