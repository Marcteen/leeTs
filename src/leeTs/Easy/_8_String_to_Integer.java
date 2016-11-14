package leeTs.Easy;

public class _8_String_to_Integer {// too slow

	public static void main(String[] args) {
		String input = "    -24143274897289347489324 fghaf";
		int result = myAtoi(input);
		System.out.println(String.format("The result is %d", result));
	}
	public static int myAtoi(String str) {
		int index = 0;
		if(str.isEmpty())
			return 0;
		else {
			while(str.charAt(index) == ' ')
				index ++;
			int symbol = 1;
			if(str.charAt(index) == '-') {
				symbol = -1;
				index ++;
			}
			else
				if(str.charAt(index) == '+')
					index ++;
			long result = 0L;
			int length = str.length();
			for(;index < length && str.charAt(index) >= '0' && str.charAt(index) <= '9'; index ++) {
				result *= 10;
				result += symbol * (str.charAt(index) - '0');
					if(result > Integer.MAX_VALUE)
						return Integer.MAX_VALUE;
					else
						if(result < Integer.MIN_VALUE)
							return Integer.MIN_VALUE;
			}
			return (int)result;
		}
	}
}
