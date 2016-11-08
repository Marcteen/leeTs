package leeTs.Medium;
import java.util.HashSet;

public class _3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		String s = "asdflkasfhkassldkgk";
		int result = lengthOfLongestSubstring(s);
		System.out.println(String.format("The result is %d", result));

	}
	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> record = new HashSet();
		int subLength = 0;
		int maxLength = 0;
		for(int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if(record.contains(curChar)){ // duplicated character detected
				if(subLength > maxLength)
					maxLength = subLength;
				subLength = 0;
				for (i --; s.charAt(i) != curChar; i --); // set next string head right behind the duplicated character
				record.clear();
			}
			else {
				subLength ++;
				record.add(curChar);
			}
			if(subLength > maxLength)
				maxLength = subLength;
		}
		return maxLength;
	}
}
