package leeTs.Easy;

public class _326_Power_of_Three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfThree(int n) {
		while(n > 0) {
			if(n % 3 > 0)
				return false;
			else
				n /= 3;
		}
		return true;
	}
	
	public boolean isPowerOfThreeTricky(int n) {
		/* the power of three must be a factor of an larger power of three
		 * so we use the largest one of integer*/
		return (n > 0 && 1162261467 % n == 0);
	}
	
	public boolean isPowerOfThreeWithNumberBaseFormation(int n) {
		return Integer.toString(n, 3).matches("10*");
	}
}
