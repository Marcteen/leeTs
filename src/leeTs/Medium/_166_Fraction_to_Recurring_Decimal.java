package leeTs.Medium;

import java.util.HashMap;

public class _166_Fraction_to_Recurring_Decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -1;
		int b = 1;
		if((a < 0) ^ (b < 0))
			System.out.println((a < 0) ^ (b < 0));
		
	}
	public String fractionToDecimal(int numerator, int denominator) {
        if(1 == denominator)
            return String.valueOf(numerator);
        else if(0 == denominator)
            return "NaN";
        else if(-1 == denominator)
            return String.valueOf(-1L * (long)numerator);
        else if(0 == numerator)
            return String.valueOf(0);
        long remainder = 0, quotient = 0;
        HashMap<Long, Integer> remainders = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0))
            builder.append('-');
        /*When a small number divided by a large number, we need to shift it left
        far, so we still need to use long to do the operation, we must convert it
        to long before conver, otherwise it may still overfloat itself!!!!!!!!*/
        long nu = Math.abs((long)numerator);
        long de = Math.abs((long)denominator);
        // append the integer quotient or zero here, no loop needed!!!!!!!!!!!!!!
        builder.append(nu / de);
        nu %= de;
        remainders.put(nu, builder.length() + 1);
        if(nu > 0)
            builder.append(".");
        while(nu > 0) {
            nu *= 10;// the rule of producing decimal!!!!!
            // we do not skip when numerator still less than dominator for best modeling
            /*for 1/99, the reminder(quotient) is 1(0), 10(0), 1(1), the last one is not
            equal with its former but the one before it, so we need a set*/
            remainder = nu % de;
            builder.append(nu / de);
            // we can't keep track of each quotient for there may be duplicated zeroes
            if(remainders.containsKey(remainder)) {
            /*because for the same reminder, it will get same quotien sequent, and we already
            keep track of the position of the leading digits, it is too small problem cause by
            the shift operation in division
            */
                builder.insert(remainders.get(remainder), "(");
                builder.append(')');
                return builder.toString();
            }
            else
                // the position it append the quotient
                remainders.put(remainder, builder.length());
            nu = remainder;

        }
        return builder.toString();
    }

}
