package leeTs.Easy;
import java.util.LinkedList;

public class _387_First_Unique_Character_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "aaadd";
		int result = firstUniqueCharTricky(input);
	}
	
	public int firstUniqueChar(String s) {
		LinkedList<Character> list = new LinkedList<>();
		int[] trace = new int[26];
		int[] firstSpot = new int[26];
		int curIndex = 0;
		for(int i = 0; i < s.length(); i ++) {
			curIndex = s.charAt(i) - 'a';
			if(trace[curIndex] == 0) {
				list.add(s.charAt(i));
				firstSpot[curIndex] = i;
			}
			trace[curIndex] ++;
		}
		for(char c : list) {
			curIndex = c - 'a';
			if(trace[curIndex] == 1)
				return firstSpot[curIndex];
		}
		return -1;
	}
	
	public static int firstUniqueCharTricky(String s) {
		if (s==null || s.length()==0) return -1;
        int len = s.length();
        if (len==1) return 0;
        char[] cc = s.toCharArray();
        int slow =0, fast=1;
        int[] count = new int[256];
        count[cc[slow]]++;
        while (fast < len) {
            count[cc[fast]]++;
            // if slow pointer is not a unique character anymore, move to the next unique one
            while (slow < len && count[cc[slow]] > 1) slow++;  
            if (slow >= len) return -1; // no unique character exist
            if (count[cc[slow]]==0) { // not yet visited by the fast pointer
                count[cc[slow]]++; 
                fast=slow; // reset the fast pointer
            }
            fast++;
        }
        return slow;
	}

}
