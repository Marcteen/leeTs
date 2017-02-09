package leeTs.Easy;

import java.util.Arrays;

public class _455_Assign_Cookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		for(int i = g.length - 1, j = s.length - 1; i >= 0 && j >= 0;) {
			if(g[i] <= s[j]) {
				count ++;
				i --;
				j --;
			}
			else {
				i --;
			}
		}
		return count;
	}
	
}
