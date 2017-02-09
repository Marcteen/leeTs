package leeTs.Easy;

public class _338_Ransom_Note {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote.length() > magazine.length())
			return false;
		else {
			int[] set = new int[26];
			for(int i = 0; i < ransomNote.length(); i ++)
				set[ransomNote.charAt(i) - 'a'] --;
			int count = ransomNote.length();
			for(int i = 0; count > 0 && i < magazine.length(); i ++) {
				if(++ set[magazine.charAt(i) - 'a'] <= 0)
					count --;
				
			}
			return count == 0;
		}
	}
	
}
