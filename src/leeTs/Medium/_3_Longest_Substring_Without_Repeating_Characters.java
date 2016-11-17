package leeTs.Medium;
import java.util.HashSet;

public class _3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int result = lengthOfLongestSubstring(s);
		System.out.println(String.format("The result is %d", result));

	}
	public static int lengthOfLongestSubstring1(String s) {
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
	public static class Record {
		int index;
		int flag;
		Record() {
			index = 0;
			flag = 0;
		}
	}
	public static int lengthOfLongestSubstring(String s) {
		Record[] notes = new Record[256];
		for(int i = 0; i < 256; i ++) {
			notes[i] = new Record();
		}
		int subLength = 0;
		int maxLength = 0;
		int flag = 1;
		for(int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if(notes[curChar].flag == flag){ // duplicated character detected
				if(subLength > maxLength)
					maxLength = subLength;
				subLength = 0;
				i = notes[curChar].index;
				flag ++; // stands for a restart
			}
			else {
				subLength ++;
				notes[curChar].index = i;
				notes[curChar].flag = flag;
			}
		}
		if(subLength > maxLength)
			maxLength = subLength;
		return maxLength;
	}
}
