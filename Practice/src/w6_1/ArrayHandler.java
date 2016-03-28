package w6_1;

import java.lang.reflect.*;
/* Создать параметризированный класс, который определяет
 * максимум, минимум, среднее арифметическое, сумму и
 * произведение массива любого числового типа.
 */
public class ArrayHandler<T extends Number>  {
	
	public  T maxElement(T[] array) throws NoSuchMethodException, SecurityException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T max = array[0];
		for(T e: array) {
			Method m = max.getClass().getMethod("compareTo", e.getClass()); 
			int result = (int)m.invoke(max, e);
			if(result < 0) max = e;
		}
		return max;
	}
	public  T minElement(T[] array) throws NoSuchMethodException, SecurityException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T min = array[0];
		for(T e: array) {
			Method m = min.getClass().getMethod("compareTo", e.getClass()); 
			int result = (int)m.invoke(min, e);
			if(result > 0) min = e;
		}
	return min; 
	}
	
	public Double average(T[] array) throws NoSuchMethodException, SecurityException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return sum(array)/array.length;
	}
	
	public Double sum(T[] array) throws NoSuchMethodException, SecurityException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Double sum = 0.0;
		for(T e: array) {	
			Method m = e.getClass().getMethod("doubleValue");
			sum += (Double)m.invoke(e);
		}
		return sum;
	}
	
	public Double product(T[] array) throws NoSuchMethodException, SecurityException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Double prod = 1.0;
		for(T e: array) {	
			Method m = e.getClass().getMethod("doubleValue");
			prod *= (Double)m.invoke(e);
		}
		return prod;
	}
/***********************************************************************/	
	public static void main(String[] args) throws NoSuchMethodException,
	SecurityException, IllegalAccessException, IllegalArgumentException,
	InvocationTargetException {
		Integer[] integerArray = {-1, 1, 2, 3, 4, 5}; 
		Double[] doubleArray = {-1.0, 1.0, 2.0, 3.0, 4.0, 5.0};
		
		ArrayHandler<Number> handl = new ArrayHandler<>();
		
		System.out.println(handl.maxElement(integerArray));
		System.out.println(handl.maxElement(doubleArray));

		System.out.println(handl.minElement(integerArray));
		System.out.println(handl.minElement(doubleArray));
		
		System.out.println(handl.average(integerArray));
		System.out.println(handl.average(doubleArray));
		
		System.out.println(handl.sum(integerArray));
		System.out.println(handl.sum(doubleArray));
		
		System.out.println(handl.product(integerArray));
		System.out.println(handl.product(doubleArray));
	}
	

}
