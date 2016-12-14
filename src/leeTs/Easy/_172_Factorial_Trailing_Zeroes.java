package leeTs.Easy;

public class _172_Factorial_Trailing_Zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trailingZeroes(int n) {
		int result = 0;
		while(n > 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}
}
