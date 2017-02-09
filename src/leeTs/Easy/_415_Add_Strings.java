package leeTs.Easy;

public class _415_Add_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addString(String num1, String num2) {
		int length = (num1.length() > num2.length() ? num1.length() : num2.length());
		char[] result = new char[length];
		length --;
		int carry = 0;
		int add1 = 0;
		int add2 = 0;
		int sum = 0;
		int i, j = 0;
		for(i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i --, j --) {
			add1 = num1.charAt(i) - '0';
			add2 = num2.charAt(j) - '0';
			sum = add1 + add2 + carry;
			if(sum >= 10) {
				sum -= 10;
				carry = 1;
			}
			else
				carry = 0;
			result[length--] = (char)(sum + '0');
		}
		if(i + j >= -1){
			int rest = 0;
			String restStr = num1;
			if(i >= 0) {
				rest = i;
			}
			else  {
				rest = j;
				restStr = num2;
			}
			for(; rest >= 0; rest --) {
				add1 = restStr.charAt(rest) - '0';
				sum = add1 + carry;
				if(sum >= 10) {
					sum -= 10;
					carry = 1;
				}
				else
					carry = 0;
				result[length--] = (char)(sum + '0');
			}
		}
		if(carry > 0)
			return String.valueOf(carry) + String.valueOf(result);
		else
			return String.valueOf(result);
	}
	
}
