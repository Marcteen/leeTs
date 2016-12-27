package leeTs.Easy;
import java.util.HashMap;
public class _290_Word_Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public boolean wordPattern(String pattern, String str) {
		String[] bunch = str.split(" ");
		HashMap<Character, String> record = new HashMap<>();
		for(int i = 0; i < bunch.length; i ++) {
			if(!record.containsKey(pattern.charAt(i))) {
				if(record.get(pattern.charAt(i)) !=  bunch[i])
					return false;
			}
			else
				record.put(pattern.charAt(i), bunch[i]);
		}
		return true;
	}
	
}
