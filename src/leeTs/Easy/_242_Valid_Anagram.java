package leeTs.Easy;

public class _242_Valid_Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isAnagram(String s, String t) {
		if(t.length() != s.length())
			return false;
		else {
			int[] charCount = new int[26];
			for(int i = 0; i < s.length(); i ++) {
				charCount[s.charAt(i) - 'a'] ++;
			}
			int index;
			for(int i = 0; i < t.length(); i ++) {
				index = t.charAt(i) - 'a';
				if(charCount[index] > 0)
					charCount[index] --;
				else
					return false;
			}
			return true;
		}
		
	}
	
}
