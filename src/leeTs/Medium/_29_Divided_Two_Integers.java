package leeTs.Medium;

public class _29_Divided_Two_Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(Integer.MIN_VALUE, 1));
	}
	// The Math.abs() has trouble casting Integer.MIN_VALUE
	public static int divide(int dividend, int divisor) {
		if(0 == divisor)
            return Integer.MAX_VALUE;
        else 
            if(Integer.MIN_VALUE == dividend && -1 == divisor) {
                return Integer.MAX_VALUE;
            }
            else {
                long dividendAbs = Math.abs((long)dividend);// Must casted to long before take absolute value, otherwise it won't get correct value of MIN_VALUE
                long divisorAbs = Math.abs((long)divisor);// for Integer.MAX_VALUE, int divisor can't reach 2^31(for there are only 31 digits) and cause infinite loop T-T
                int symbol = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;// or use Integer.signum(x) to get the symbol of a number
                long shiftedDivisorAbs = 0;
                long quotient = 0;// for the MIN_VALUE / 1 case, int can't hold its absolute value !!!
                long curQuotient = 0;
                while(dividendAbs >= divisorAbs) {// the equal operator is prone to be ignored
                    curQuotient = 1;
                    shiftedDivisorAbs = divisorAbs;
                    while((shiftedDivisorAbs << 1) <= dividendAbs) {// very concise becaues it acts like a peek()!!! no extra minusing 1 out of this loop....
                        shiftedDivisorAbs <<= 1;// don't forget the self-operator!!
                        curQuotient <<= 1;
                    }
                    quotient += curQuotient;
                    dividendAbs -= shiftedDivisorAbs;
                }
                return (int)(quotient * symbol);
            }
    }
}
