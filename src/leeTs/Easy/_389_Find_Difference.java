package leeTs.Easy;

public class _389_Find_Difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public char findTheDifference(String s, String t) {
		int[] trace = new int[256];
		for(int i = 0; i < s.length(); i ++)
			trace[s.charAt(i)] ++;
		for(int i = 0; i < t.length(); i ++)
			if(trace[t.charAt(i)] == 0)
				return t.charAt(i);
			else
				trace[t.charAt(i)] --;
		return 'a';
	}
}
