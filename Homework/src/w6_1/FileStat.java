package w6_1;

import java.io.*;
import java.util.regex.*;

/*Программа FileStat. Написать программу, которая анализирует и собирает статистику о
 *  заданном в параметрах командной строки текстовом файле. Статистика должна содержать следующие данные:
a. Количество строк
b. Количество предложений 
c. Количество слов
d. Количество символов (размер файла)
   Сбор и хранение статистики организовать в отдельном классе FileStat, которому в конструкторе
   передается имя файла. В классе предусмотреть возможности:
e. печати общего отчета по статистике, включающем имя файла и все данные
f. получение отдельных данных, в т.ч. имя файла
*/
public class FileStat  {
	private final String fileName;
	private int numberOfSymbols;
	private int numberOfWords;
	private int numberOfSentences;
	private int numberOfLines;
	
	public FileStat(String fileName) throws IOException { 
		this.fileName = fileName;
		getStatistics(fileName);
	}
	private void getStatistics(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();
		String s = null;
		int lineCount = 0, sentenceCount = 0, wordCount = 0, symbolCount = 0;
		
		while(( s = in.readLine()) != null) {
			lineCount++; 
			sb.append(s);
			wordCount += s.split(" ").length; 
		}
		
		Pattern p = Pattern.compile("[.!?]");
		Matcher m = p.matcher(sb.toString());
		while(m.find()) {
				sentenceCount++;
		}
		symbolCount = sb.toString().length() + lineCount - 1;
		
		numberOfLines =  lineCount;
		numberOfSentences =  sentenceCount;
		numberOfWords = wordCount;
		numberOfSymbols = symbolCount;
		
		in.close();
	}
	public String getFileName() {
		return fileName;
	}
	public int getNumberOfSymbols() {
		return numberOfSymbols;
	}
	public int getNumberOfWords() {
		return numberOfWords;
	}
	public int getNumberOfSentences() {
		return numberOfSentences;
	}
	public int getNumberOfLines() {
		return numberOfLines;
	}
	public void printStatistics(PrintStream ps) {
		ps.println(getFileName());
		ps.println("Number of symbols \t" + getNumberOfSymbols());
		ps.println("Number of words \t" + getNumberOfWords());
		ps.println("Number of sentences \t" + getNumberOfSentences());
		ps.println("Number of lines \t" + getNumberOfLines());
	}
	public void update() throws IOException {
		getStatistics(getFileName());
	}
	public static void main(String[] args) throws IOException {
		
		FileStat fileStat = new FileStat(args[0]);
		fileStat.printStatistics(System.out);
		fileStat.update();
		fileStat.printStatistics(new PrintStream(new FileOutputStream(fileStat.getFileName() + ".stat")));
	}
}
