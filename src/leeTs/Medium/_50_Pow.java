package leeTs.Medium;

public class _50_Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public double myPow(double x, int n) {
        long countOnes = Math.abs((long)n);/* must cast to long before take abs, 
        because it can't handle Integer.MIN_VALUE*/
        double result = 1;
        while(countOnes > 0) {// since x^n * x^m = x^(n + m), we decompse n in binary, and roll up x in square
            // be careful about the operator combination!! use bracket is best
        	if((countOnes & 1) == 1)// it means n have this digit in binary form
                result *= x;// take the correponding pow
            countOnes >>>= 1;
            x *= x;
        }
        return n > 0 ? result : 1 / result;
    }
}
