package leeTs.Easy;

public class _171_Excel_Sheet_Column_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int titleToNumber(String s) { // to be formal, Z equals to A0
		int result = 0;
		int curValue = 0;
		for(int i = 0; i < s.length(); i ++) {
			result *= 26;
			if('A' == s.charAt(i))
				curValue = 1;
			else
				curValue = s.charAt(i) - 'A';
			result += curValue;
		}
		return result;
	}
}
