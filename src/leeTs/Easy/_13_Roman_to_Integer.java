package leeTs.Easy;

public class _13_Roman_to_Integer {

	public static void main(String[] args) {
		String input = "MDCCCLXXXVIII";
		int result = romanToInt(input);
		System.out.println(String.format("The result is %d", result));
	}
	
	public static int romanToInt(String s) {
		int result = 0;
		int lastValue;
		int curValue = 0;
		int length = 1;
		for(int i = 1;i < s.length();i++) {
			if(s.charAt(i - 1) == s.charAt(i))
				length ++;
			else {
				lastValue = getValue(s.charAt(i - 1));
				curValue = getValue(s.charAt(i));
				if(curValue > lastValue) {// may be a difference to former
					if(isReducable(s.charAt(i - 1)))
						result -= length * lastValue;
					else
						result += length * lastValue;
				}
				else { // accumulate the same symbols
					result += length * lastValue;
				}
				length = 1;
				
			}
		}
		lastValue = getValue(s.charAt(s.length() - 1));
		result += length * lastValue;
		return result;
	}
	public static int getValue(char c) {
		int value = 0;
		switch(c) {
		case 'I':
			value = 1;
			break;
		case 'V':
			value = 5;
			break;
		case 'X':
			value = 10;
			break;
		case 'L':
			value = 50;
			break;
		case 'C':
			value = 100;
			break;
		case 'D':
			value = 500;
			break;
		case 'M':
			value = 1000;
		}
		return value;
	}
	public static boolean isReducable(char c) {
		if(c == 'I' || c == 'X' || c == 'C')
			return true;
		else
			return false;
	}
}
