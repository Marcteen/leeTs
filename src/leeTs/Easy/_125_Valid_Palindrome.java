package leeTs.Easy;

public class _125_Valid_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPalindrome(String s) {
		if("" == s)
			return true;
		else {
			String ss = s.toLowerCase();
			int head = 0;
			int tail = ss.length() - 1;
			char headChar = 0;
			char tailChar = 0;
			while(head < tail) {
				headChar = ss.charAt(head);
				tailChar = ss.charAt(tail);
				if(isCharactor(headChar)) {
					if(isCharactor(tailChar)) {
						if(headChar != tailChar)
							return false;
						else{
							tail --;
							head ++;
						}
					}
					else {
						tail --;
					}
				}
				else 
					head ++;
			}
			return true;
		}
	}
	
	public static boolean isCharactor(char c) {
		if(c <= 'z' && c >= 'a')
			return true;
		else
			if(c <= 'Z' && c >= 'A')
				return true;
			else
				if(c <= '9' && c >= '0')
				    return true;
				else
				    return false;
	}
}
