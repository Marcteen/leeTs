package leeTs.Medium;

import java.util.HashSet;
import java.util.List;

public class _139_Word_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Using dp, we construct the breakable of prefix [n + 1](exclusive bound)
	 * using the suffix's existence in wordDict and the rest front part's breakable*/
	public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        if(wordSet.contains(s))
            return true;
        int length = s.length();
        boolean[] breakable = new boolean[length + 1];// upper bound excluded
        breakable[0] = true;
        for(int end = 0; end < length; end ++) {
            for(int start = 0; start <= end; start ++){
                if(wordSet.contains(s.substring(start, end + 1)))
                    if(breakable[start])
                        breakable[end + 1] = true;
            }
        }
        return breakable[length];
    }
}
