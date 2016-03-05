package w3_1;
/**Write a function named countChars that has a String and a char as
*parameters. The function should count the number of times the
*character occurs in the string, and it should return the result as
*the value of the function.
*/
public class Task3 {
	static int countChars(final String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i ++) {
			if (str.charAt(i) == c)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		String s = "How many characters are here";
		System.out.println(countChars(s, 'e'));
		System.out.println(countChars(s, 'a'));
		System.out.println(countChars(s, 'u'));

	}

}
