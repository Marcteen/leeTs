package leeTs.Medium;

public class _43_Multiply_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/*https://discuss.leetcode.com/topic/30508/easiest-java-
	 * solution-with-graph-explanation*/
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.equals("1"))
            return num2;
        if(num2.equals("1"))
            return num1;
        int totalLength = num1.length() + num2.length();
        int productDigit = 0;
        int carry = 0;
        int targetBase = 0;
        StringBuilder product = new StringBuilder();
        int[] productNum = new int[totalLength];
        for(int i = num1.length() - 1; i >= 0; i --)
        	for(int j = num2.length() - 1; j >= 0; j --) {
        		targetBase = i + j + 1;// at first, it is totalength - 1!!!!!
        		productNum[targetBase] = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)) + productNum[targetBase];// be careful about the assignment
        		carry = productNum[targetBase] / 10;
        		productNum[targetBase] %= 10;
        		while(carry > 0) {
        			productNum[-- targetBase] += carry;
        			carry = productNum[targetBase] / 10;
        			productNum[targetBase] %= 10;
        		}        		
        	}
        int i = -1;
        while(0 == productNum[++ i]);// Remeber to filer the prefix 0, and not the 0 in the middle!!!!!!!!!
        for(; i < totalLength; i ++)
            product.append((char)('0' + productNum[i]));// '0' is still an int, so we should do cast after the sum
        return product.toString();
	}
	//Modify the char in StringBuffer is horrible, 
	public String multiplyNaive(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.equals("1"))
            return num2;
        if(num2.equals("1"))
            return num1;
        int totalLength = num1.length() + num2.length();
        StringBuilder product = new StringBuilder();
        int[] productNum = new int[totalLength];
        int pos1 = num1.length() - 1, pos2 = 0, resPos = 0;
        int carry = 0;
        int productDigit = 0;
        while(pos1 >= 0) {
            pos2 = num2.length() - 1;
            resPos = totalLength - (num1.length() - pos1);// add to the result digits
            while(pos2 >= 0) {
                productDigit = Character.getNumericValue(num1.charAt(pos1)) * Character.getNumericValue(num2.charAt(pos2)) + carry + productNum[resPos];
                carry = productDigit / 10;
                productNum[resPos] = productDigit % 10;
                pos2 --;
                resPos --;
            }
            if(carry > 0) {
                productNum[resPos] = carry;
                carry = 0;// don't forget to reset the passing carry!!!!!!!
            }
            pos1 --;
        }
        int i = -1;
        while(0 == productNum[++ i]);// Remeber to filer the prefix 0, and not the 0 in the middle!!!!!!!!!
        for(; i < totalLength; i ++)
            product.append((char)('0' + productNum[i]));// '0' is still an int, so we should do cast after the sum
        return product.toString();
    }
	
}
