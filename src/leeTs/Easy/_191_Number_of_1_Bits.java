package leeTs.Easy;

public class _191_Number_of_1_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingWeight(int n ) {
		int result = 0;
		while(n > 0) {
			result += (n & 1);
			n >>>= 1;
		}
		return result;
	}
	
}
