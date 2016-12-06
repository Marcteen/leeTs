package leeTs.Easy;

public class _191_Number_of_1_Bits {
	public static void main(String[] args) {
		
	}
	public int hamingWeight(int n) {
		int result = 0;
		do { // use do-while in case that n equals to 10000...00(only symbol bit is one), indeed a very subtle wrap shown as "none" in test case info
			result += (n & 1);
			n >>>= 1; // This operator will treat the symbol as a bit of number and shift it together
		}while(n > 0);
		return result;
	}
	
	public int hamingWeightFaster(int n) {
		int result = 0;
		if((n & 1) == 1) // check the last bit first because it will be removed for guaranteeing the symbol bit
			result ++;
		n >>>= 1;//
		while(n > 0) {
			n &= (n - 1);// this will set the last 1 to 0, and the value decreases
			result ++;
		}
		
		return result;
	}
}
