package leeTs.Easy;

public class _172_Factorial_Trailing_Zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* we need 2 and 5 to form the trailing zeroes, and every
	 * odd number has 2 as factor which is sure to be sufficient,
	 * so we just need to concern the number of fives*/
	public int trailingZeroes(int n) {
		int result = 0;
		/*basically, all the multiplier of 5^m (m = 1, 2, 3...) provide
		 * 5, but for 5^m, it only provide one more 5 because we have
		 * count it in 5^(m - 1), just like n / 5 + n / 25 + n / 125 + ...,
		 * but here we let n /= 5 (decrease the dividend) in each iteration
		 * to get the same result as increasing the divisor*/
		while(n > 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}
}
