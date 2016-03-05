package w3_1;

import scannerUtil.NumberScanner;

/*25. В восточном календаре принят 60-летний цикл, состоящий из 12-летних
 *  подциклов, обозначаемых названиями цвета: зеленый, красный, желтый, белый
 *   и черный. В каждом подцикле годы носят названия животных: крысы, коровы,
 *    тигра, зайца, дракона, змеи, лошади, овцы, обезьяны, курицы, собаки
 *     и свиньи. По номеру года определить его название, если 1984 год — 
 *     начало цикла: «год зеленой крысы».
 */
public class Task25 {
	public static String convertYearNumberToZodiacColor(int year) {
		final String[] ZODIAC = {"Rat", "Ox", "Tiger", "Rabbit", "Dragon",
				"Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig"};
		final String[] COLOR = {"Green", "Red", "Yellow", "White", "Black"};
		final int START_YEAR = 1984;
		int yearCounter = START_YEAR, colorCounter = 0, zodiacCounter = 0;
		if(year >= START_YEAR) {
			//move forward till match
			while(true) {
				if(yearCounter == year)
					return (COLOR[colorCounter] + " " 
							+ ZODIAC[zodiacCounter]);
			
				zodiacCounter = ((zodiacCounter + 1) % 12);
				if ((yearCounter % 2) == 1) 
					colorCounter = ((colorCounter + 1) % 5);
				yearCounter ++;
			}
		} else {
			//move backward till match
			while(true) {
				if(yearCounter == year)
					return (COLOR[colorCounter] + " " 
							+ ZODIAC[zodiacCounter]);
			
				zodiacCounter = ((-- zodiacCounter) >= 0 ? 
						zodiacCounter : 11 );
				if ((yearCounter % 2) == 0) 
					colorCounter = ((-- colorCounter) >= 0 ?
						colorCounter : 4);
				yearCounter --;
			}
		}
	}
		
	public static void main(String[] args) {
		int year = 0;
		year = NumberScanner.input(year, "Enter a year: ");
		System.out.println(year + " is the year of " + 
				convertYearNumberToZodiacColor(year));
	}

}
