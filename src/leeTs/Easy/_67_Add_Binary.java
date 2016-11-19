package leeTs.Easy;

public class _67_Add_Binary {

	public static void main(String[] args) {
		String a = "1010";
		String b = "1011";
		String result = addBinary(a, b);
		System.out.println(String.format("The result is : %s", result));
	}

	public static String addBinary(String a, String b) {
		int maxLength = 0;
		int carry = 0;
		int sum = 0;
		if(a.length() > b.length())
			maxLength = a.length();
		else
			maxLength = b.length();
		char[] result = new char[maxLength + 1];
		int ai = a.length() - 1;
		int bi = b.length() - 1;
		while(ai >= 0 && bi >= 0) {
			sum = a.charAt(ai) + b.charAt(bi) - '0' * 2 + carry;
			if(sum > 1) {
				sum -= 2;
				carry = 1;
			}
			else
				carry = 0;
			result[maxLength] = (char)(sum + '0');
			ai --;
			bi --;
			maxLength --;
		}
		int ci = 0;
		String c = "";
		if(ai >= 0) {
			ci = ai;
			c = a;
		}
		else{
			ci = bi;
			c = b;
		}
		while(ci >= 0) {
			sum = c.charAt(ci) - '0' + carry;
			if(sum > 1) {
				sum -= 2;
				carry = 1;
			}
			else
				carry = 0;
			result[maxLength] = (char)(sum + '0');
			ci --;
			maxLength --;
		}
		if(1 == carry) {
			result[0] = '1';
			return new String(result);
		}
		else {
			return new String(result).substring(1);
		}
	}
}
