//Напишите метод, который выводит для номера телефона все возможные 
//комбинации английских букв телефонной клавиатуры. Используйте 
//вспомогательный прототип: char getCharKey(int phoneKey, int place)
//который возвращает букву телефонной клавиши по порядку букв этой клавиши. Цифры 0 и 1 на буквы не заменяются.

import java.util.LinkedList;
import java.util.List;

public class PhoneWord {
	 
	public static List<String> letterCombinations(String digits) {
	    
		LinkedList<String> results = new LinkedList<>();
	    results.add("");

	    for (int i = 0; i < digits.length(); i++) {
	        int dig = Integer.parseInt("" + digits.charAt(i));
	        for (int j = results.size(); j > 0; j--) {
	            String intermediateResult = results.poll();
	            for (int k = 0; k < charKey[dig].length; k ++) {
	               
	            	results.add(intermediateResult + getCharKey(dig, k));
	            }
	        }
	    }
	    return results;
	}
	
	private static char[][] charKey = {
			{' ', ' ', ' '},	//0
			{' ', ' ', ' '},	//1
			{'a','b','c'},		//2
			{'d','e','f'},		//3
			{'g','h','i'},		//4
			{'j','k','l'},		//5
			{'m','n','o'},		//6
			{'p','q','r','s'},	//7
			{'t','u','v'},		//8
			{'w','x','y','z'}	//9
	};
	private static char getCharKey(int phoneKey, int place) {
		return charKey[phoneKey][place];
	}
	

	public static void main(String[] args) {
		
		 System.out.println(letterCombinations("234"));
		 
	}

}
