package leeTs.Easy;

public class _231_Power_of_Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPowerOfTwoTricky(int n) { // a trick to handle the 1 that near the end !
		if(n <= 0)
			return false;
		else
			if(0 != (n & (n - 1)))
				return false;
			else
				return true;
	}
	
	public boolean isPowerOfTwo(int n) {
		int countOne = 0;
		while(n > 0) {
			n >>= 0;
			if((n & 1) == 1) {
				countOne ++;
				if(countOne > 1)
					return false;
			}
		}
		if(1 == countOne)
			return true;
		else
			return false;
	}

}
