import java.util.*;

//Напишите метод, выводящий все возможные неповторяющиеся комбинации (перестановки)
//символов исходного текста. Порядок перестановок не имеет значения
public class CharPermutation {
	private Set<String> stringSet = new HashSet<>();
	private boolean[] usedChar;
    private StringBuilder sb = new StringBuilder();
    private final String str;
    public CharPermutation( final String str ) {
        this.str = str;
        usedChar = new boolean[ str.length() ];
    }
    public void permute( ){
        if( sb.length() == str.length() ) {
            if(!stringSet.contains(sb.toString())) {
            	System.out.println(sb);
            	stringSet.add(sb.toString());
            }
            return;
        }
        for( int i = 0; i < str.length(); i++ ) {
            if( usedChar[i] ) continue;
            sb.append( str.charAt(i) );
            usedChar[i] = true;
            permute();
            usedChar[i] = false;
            sb.setLength( sb.length() - 1 );
        }
    }
	public static void main(String[] args) {
		CharPermutation p = new CharPermutation("aba");
		p.permute();
	}

}
