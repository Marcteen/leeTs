package leeTs.Easy;

import java.util.List;
import java.util.ArrayList;

public class _438_Find_All_Anagrams_in_a_String {

	public static void main(String[] args) {
		char[] ls = new char[5];
		int a = ls[0];
		int b = ls[4];
		System.out.println(ls);
	}

	public static List<Integer> findAnagram(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if(s.length() < p.length())
			return result;
		else {
			int[] trace = new int[256];// Don't use char[]!!!! It is a counting array.
			int head = 0, tail = 0, count = p.length();
			for(char c : p.toCharArray())
				trace[c] ++;
			while(tail < s.length()) {// the trace[] would change anyway, but the symbol indicates the corresponding action
				if(trace[s.charAt(tail ++)] -- > 0)// we add a character exist in p
					count --;
				if(0 == count)
					result.add(head);// the sliding windows just contain the anagram
				if(p.length() == tail - head)
					if(trace[s.charAt(head ++)] ++ >= 0)
						count ++;// we drop a character exist in p
			}
			return result;
		}
	}
}
