package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;

public class _131_Palindrome_Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>>[] result = new List[6 + 1];
	}
	
	public List<List<String>> partitionDp(String s) {
        if(null == s)
            return new ArrayList<>();
        int length = s.length();
        //store the partition result from begin to n(exclusive)
        List<List<String>>[] dp = new List[length + 1];
        dp[0] = new ArrayList<>();// the array is just some null references!!!
        dp[0].add(new ArrayList<String>());// 0 exclusive to have an empty start !!!
        List<String> pool = null;
        boolean[][] isPalindrome = new boolean[length][length];
        for(int i = 0; i < length; i ++) {//grow the lower bound of input
            // grow the lower bound of previous result(construct [n + 1] with [i] and palidrome i ~ n)
            dp[i + 1] = new ArrayList<>();// first must prepare it
            for(int j = 0; j <= i; j ++) {
                //check if it is a palindrome, maybe construct by former record
                if(i == j || s.charAt(j) == s.charAt(i) && (j + 1 == i || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;//mark it for the future
                    // j is inclusive in this palindrome but exclusive in [j], there is several combination
                    for(List<String> list : dp[j]) {
                        pool = new ArrayList<>(list);
                        pool.add(s.substring(j, i + 1));// construct [i + 1]
                        //don't mistaken with addAll() here!!!
                        dp[i + 1].add(pool);
                    }
                }
            }
        }
        // be careful about the index !!!!!
        return dp[length];
    }
	//just a violent method in recursive
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(null == s || 0 == s.length())
            return result;
        List<String> current = new ArrayList<>();
        getPalindromes(s, 0, current, result);
        return result;
    }
    
    public void getPalindromes(String s, int start, List<String> current, List<List<String>> result) {
        String sub = null;
        for(int end = start + 1; end <= s.length(); end ++){
            sub = s.substring(start, end);
            if(isPalindrome(sub)) {
                current.add(sub);
                if(end == s.length())
                    result.add(new ArrayList<String>(current));
                else
                    getPalindromes(s, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str) {
        if(null == str)
            return false;
        for(int start = 0, end = str.length() - 1; start <= end; start ++, end --)
            if(str.charAt(start) != str.charAt(end))
                return false;
        return true;
    }
}
