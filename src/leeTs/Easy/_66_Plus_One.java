package leeTs.Easy;

public class _66_Plus_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] plusOne(int[] digits) {
		int[] result = new int[digits.length + 1];
		int carry = 1;
		int sum = 0;
		for(int i = digits.length - 1; i >= 0; i --) {
			if(0 != carry) {
				sum = digits[i] + carry;
				if(sum >= 10) {
					sum -= 10;
					carry = 1;
				}
				else {
					carry = 0;
				}
				result[i] = sum;
				digits[i] = sum;
			}
			else
				break;

		}
		if(carry > 0) {
			result[0] = 1;
			return result;
		}
		else
			return digits;
	}
}
