import java.util.*;
//Реализуйте класс для поиска неповторяющихся слов в тексте (первого и последнего).

public class RepeatedWords {
	private String first, last;
	public RepeatedWords( String s) {
		s = s.replaceAll("[,.?!:]", " ");
		String[] words = s.split("\\s+");
		Set<String> wordsSet = new HashSet<>(); 
		List<String> wordsList = new ArrayList<>();
		for(int i = 0; i < words.length; i ++) {
			String word = words[i].toLowerCase();
			if(!(wordsSet.contains(word))) {
				wordsSet.add(word); 
				wordsList.add(word); 
			} else 
					wordsList.remove(word);
			
		}
		int size = wordsList.size();
		if(size >= 1) setFirst(wordsList.get(0));
		if(size >= 2) setLast(wordsList.get(size - 1));
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "We love Java, but we don't really know if java love us."
				+ " What a cruel java.";
		RepeatedWords rw = new RepeatedWords(str);
		System.out.println("First unrepeated word is " + rw.getFirst());
		System.out.println("Last unrepeated word is " + rw.getLast());
	}

}
