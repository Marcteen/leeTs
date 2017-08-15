package leeTs.Medium;

public class _5_Longest_Palindromic_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Or we can use dp, generating the palindrome substring indicator
	 * dp[from][to] by growing the length of them*/
	
	
	public static String longestPalindrome(String s) {
        int curLength = 0;
        String longest = "";
        for(int i = 0; i < s.length(); i ++) {// add single character each time and validate inversely
            if(isPalindrome(s, i - curLength - 1, i)){// assuming the palindrome's length is odd
                longest = s.substring(i - curLength - 1, i + 1);
                curLength += 2;// assuming to grow the odd palindromic string
            }
            if(isPalindrome(s, i - curLength, i)) {// assuming the palindrome's length is even
                longest = s.substring(i - curLength, i + 1);
                curLength += 1;// assuming to grow the even palindromic string
            }
        }
        return longest;
    }
    
    public static boolean isPalindrome(String s, int head, int tail) {// comparing from two ends to the middle will make these two case become easily to handle.
        if(head < 0)
            return false;
        while(head < tail) {
            if(s.charAt(head ++) != s.charAt(tail --))
                return false;
        }
        return true;
    }
	
}
