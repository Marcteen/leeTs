package leeTs.Easy;
import java.util.HashMap;
public class _290_Word_Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "dog cat cat dog";
		boolean result = wordPattern(pattern, str);
	}

	public static boolean wordPattern(String pattern, String str) {
		if("".equals(pattern))
            return false;
        else {
            String[] bunch = str.split(" ");
            if(bunch.length != pattern.length())
                return false;
            else {
            	/* Need two-way map to check, and string need to use their overwritten equals()
            	 * for equal value determine*/
                HashMap<Character, String> record = new HashMap<>();
                HashMap<String, Character> inverseRecord = new HashMap<>();
        		for(int i = 0; i < bunch.length; i ++) {
        			if(record.containsKey(pattern.charAt(i))) {
        				if(!record.get(pattern.charAt(i)).equals(bunch[i]))
        					return false;
        			}
        			else
        			    if(inverseRecord.containsKey(bunch[i])) {
        			            return false;
        			    }
        			    else{
        			        record.put(pattern.charAt(i), bunch[i]);
        			        inverseRecord.put(bunch[i], pattern.charAt(i));
        			    }
        		}
        		return true;
            }
        }
	}
	
}
