package leeTs.Hard;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;

public class _30_Substring_with_Concatenation_of_All_Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "barfoothefoobarman";
		String[] words = new String[]{"foo", "bar"};
		List<Integer> result = findSubstring(s, words);
		for(int i : result)
			System.out.println(i);
	}
	public static List<Integer> findSubstring(String s, String[] words) {
        if(null == s || null == words || 0 == s.length() || 0 == words.length || 0 == words[0].length())
            return null;
        LinkedList<Integer> result = new LinkedList<>();
        /*int last : the start points behind it doesn't has enough letter to form a valid word, excluded*/
        int lenS = s.length(), numWords = words.length, lenWord = words[0].length(), last = lenS - lenWord + 1, numDistinctWords = 0;
        /*[0][:] for the number of words in words[], [1][:] for checking process*/
        int[][] dict = new int[2][numWords];
        /*indicate the word's index from each start poins in s, -1 if not exists*/
        int[] exists = new int[last];
        String maybeWord = null;
        /*Get the numbers of each distinct word, and the map to their corresponding index*/
        HashMap<String, Integer> word2Index = new HashMap<>();
        for(int i = 0; i < numWords; i ++) {
            if(!word2Index.containsKey(words[i])) {
                word2Index.put(words[i], numDistinctWords);
                numDistinctWords ++;
            }
            dict[0][word2Index.get(words[i])] ++;
        }
        /*computing exists, traversing and check all index if they are valid words beginnings*/
        for(int i = 0; i < last; i ++) {
            maybeWord = s.substring(i, i + lenWord);
            if(word2Index.containsKey(maybeWord)) {
                exists[i] = word2Index.get(maybeWord);
            } else {
                exists[i] = -1;
            }
        }
        /*use a sliding windows to find each solution, and move in the start point 1 by 1*/
        for(int i = 0; i < lenWord; i ++) {
        	//noted that left and right always step in a word length
            int left = i, right = i, numNotCoveredWords = numDistinctWords;
            /*traverse until all words have been covered*/
            while(right < last) {
            	while(right < last && numNotCoveredWords > 0) {
                    if(exists[right] != -1) {
                        // just find all elements for one distinct word
                        if(++ dict[1][exists[right]] == dict[0][exists[right]])
                            numNotCoveredWords --;
                    }
                    right += lenWord;
                }
                /*There may be some redundant words(as prefix) or unwanted interval, so try to narrow it*/
                while(left < right && numNotCoveredWords == 0) {
                    if(exists[left] != -1) {
                        /*if we get it non fully covered after delete this word, we may just run into a solution*/
                        if(-- dict[1][exists[left]] == dict[0][exists[left]] - 1) {
                        	numNotCoveredWords ++;
                        //we have hold just all the needed words, if it has same length, surely it will be the solution
                            if(right - left == numWords * lenWord)
                                result.add(left);
                        }
                    }
                    left += lenWord;
                }
            }
            Arrays.fill(dict[1], 0);
        }
        return result;
    }
}
