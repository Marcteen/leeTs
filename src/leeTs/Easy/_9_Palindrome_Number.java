package leeTs.Easy;

public class _9_Palindrome_Number { // too slow

	public static void main(String[] args) {
		int input = 1001;
		boolean result = isPalindrome(input);
		if(true == result)
			System.out.println("The answer is true");
		else
			System.out.println("The answer is false");
	}
	public static boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		else {
			long xAbs = Math.abs((long)x);
	        long bits = 1;
	        for(long i = xAbs; i >= 10; i /= 10)
	        	bits *= 10;
	        long tail = 0;
	        long head = 0;
	        while(bits >= 10) {// till still sub digits array for judge
	        	tail = xAbs % 10;
	        	head = xAbs / bits % 10;// select the current head without removing high digits
	        	if(head == tail) {
	        		xAbs /= 10;
	        		bits /= 100;
	        	}
	        	else
	        	{
	        		return false;
	        	}
	        }
	        return true;
		}
    }
	
	public static boolean isPalindrome_Number1(int x) { // a tric for avoiding overflow
		if (x < 0) return false;

	    int p = x; 
	    int q = 0; 
	    
	    while (p >= 10){
	        q *= 10; 
	        q += p % 10; 
	        p /= 10; 
	    }
	    
	    return q == x / 10 && p == x % 10; // reserve one digit!
	}

}
