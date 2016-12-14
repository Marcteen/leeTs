package leeTs.Easy;

public class _190_Reverse_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverseBits(int n) {
		int result = 0;
	    for(int i = 0; i < 32; i ++) {
	    	result += n & 1;
	    	n >>>= 1;// unsigned shift
	    	if(i < 31)
	    		result <<= 1;
	    }
	    return result;
	}
	
}
