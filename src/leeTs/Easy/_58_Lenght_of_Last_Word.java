package leeTs.Easy;

public class _58_Lenght_of_Last_Word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int lengthOfLastWord(String s) {
		int length = 0;
		boolean start = false;
		for(int i = s.length() - 1; i >= 0; i --) {
			if(start) {
				if(' ' != s.charAt(i)) {
					length ++;
				}
				else
					break;
			}
			else {
				if(' ' != s.charAt(i)) {
					start = true;
					length ++;
				}
			}
		}
		return length;
	}
}
