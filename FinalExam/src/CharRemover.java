//Напишите эффективный метод, удаляющий символы из строки. Воспользуйтесь прототипом:
//String removeChars(String inputString, String removeString)
//метод удаляет из строки inputString все символы, входящие в строку removeString.
public class CharRemover {
	public static String removeChars(String inputString, String removeString) {
		StringBuilder sb = new StringBuilder(inputString); 
		char[] chars= removeString.toCharArray();
		for( int i = 0; i < sb.length(); i ++) {
			char ch = sb.charAt(i); 
			for(char c: chars) {
				if(c == ch) {
					sb.deleteCharAt(i);
					i--;
				}
			}
		}
	
		return sb.toString();
	}
	public static void main(String[] args) {
		String input= "Hello word of Java.";
		System.out.println(input);
		String removeString = "ola";
		System.out.println(removeChars(input, removeString));

	}

}
