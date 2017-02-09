package leeTs.Easy;

public class _400_Nth_Digit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 11;
		int output = findNthDigit(input);
	}
	
	public static int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len; //linked regularization with a bias!!!!
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}

}
