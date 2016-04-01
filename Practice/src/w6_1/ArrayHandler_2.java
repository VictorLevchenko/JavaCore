package w6_1;
public class ArrayHandler_2<T extends Number>  {
	
	public  T maxElement(T[] array) {
		T max = array[0];
		for(T e: array) {
			if(max.doubleValue() < e.doubleValue()) max = e;
		}
		return max;
	}
	public  T minElement(T[] array) {
		T min = array[0];
		for(T e: array) {
			if(min.doubleValue() > e.doubleValue()) min = e;
		}
	return min; 
	}
	
	public Double average(T[] array) {
		return sum(array)/array.length;
	}
	
	public Double sum(T[] array) {
		Double sum = 0.0;
		for(T e: array) {	
			sum += e.doubleValue();
		}
		return sum;
	}
	
	public Double product(T[] array) {
		Double prod = 1.0;
		for(T e: array) {	
			prod *= e.doubleValue();
		}
		return prod;
	}
/***********************************************************************/	
	public static void main(String[] args) {
		Integer[] integerArray = {-1, 1, 2, 3, 4, 5};
		Double[] doubleArray = {-1.0, 1.0, 2.0, 3.0, 4.0, 5.0};
		
		ArrayHandler_2<Number> handl = new ArrayHandler_2<>();
		
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
