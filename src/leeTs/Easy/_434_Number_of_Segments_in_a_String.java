package leeTs.Easy;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class _434_Number_of_Segments_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "";
		int output = countSegments(input);
	}
	
	public static int countSegments(String s) {
		if(s.equals(""))
			return 0;
		else {
			int state = 0;
			int count = 0;
			for(char c : s.toCharArray()) {
				switch(state) {
				case 0: 
					if(' ' != c) {
						state = 1;
						count ++;
					}
					break;
				case 1:
					if(' ' == c)
						state = 0;
				}
			}
			return count;
		}
	}

	public static int countSegmentsWithRegex(String s) {
		if(s.equals(""))
			return 0;
		String regEx = " +";
		Pattern pat = Pattern.compile(regEx);
		return pat.split(s).length;
	}
}
