package leeTs.Easy;

public class _409_Longest_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* well there must exist the palindrome, but we need to 
	 * find it exactly, just need to peek it property*/
	public int longestPalindrome(String s) {
		int[] trace = new int[256];
		int single = 0;
		int _double = 0;
		for(char c : s.toCharArray()) {
			if(0 == trace[c]) {
				single ++;
				trace[c] ++;
			}
			else
				if(1 == trace[c]) {// set to zero because we already have a pair
					single --;
					_double ++;
					trace[c] = 0;
				}
		}
		return single > 0 ? _double * 2 + 1 : _double * 2;
	}
	
}
