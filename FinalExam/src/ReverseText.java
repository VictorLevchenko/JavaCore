//Напишите метод, меняющий порядок слов в тексте на обратный.
//Предполагается, что все слова разделены пробелами. 
//Знаки препинания относятся к буквам.
public class ReverseText {
	public static String reverse(String text) {
		String [] words = text.split(" ");
		int size = words.length;
		for(int i = 0, j = size-1; i < size/2; i ++, j--) {
			String s = words[i];
			words[i] = words[j];
			words[j] = s;
		}
		StringBuilder sb = new StringBuilder();
		for(String s: words) sb.append(s + " ");
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "Hello my little Java";
		System.out.println(s);
		System.out.println(reverse(s));

	}

}
