package w3_1;
/*Write a subroutine with three parameters of type int. The subroutine
*should determine which of its parameters is smallest. The value of
*the smallest parameter should be returned as the value of the
*subroutine.
*/

public class Task4 {
	static int smallestInt(int ... dig) {
		int result = Integer.MAX_VALUE;
		for(int a: dig) {
			if (a < result) result = a;
		}
		return result;
	}
	public static void main(String[] args) {
		
		System.out.println(smallestInt(1,2,3));
		System.out.println(smallestInt(1,-2,3));
		System.out.println(smallestInt(1,-27,3,-60,100,0));
	}
}

