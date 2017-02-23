package leeTs.Medium;

import java.util.List;
import java.util.HashSet;

public class _127_Word_Ladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> s = null;
		HashSet<String> set = new HashSet<>(s);

	}
	/*It said every step should be in wordList, so it will be no way if endWord is
	 * not in wordList*/
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), words = new HashSet(wordList), temp;
        if(!words.contains(endWord))
            return 0;
        int step = 1;// Be careful about the description!!!!!
        String target;
        char buff[], c;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()) {// balance the two set
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            step ++;// if we find it in this loop, it would be the answer
            temp = new HashSet<>();
            for(String str : beginSet) {
                buff = str.toCharArray();
                for(int i = 0; i < buff.length; i ++) {
                    c = (char)(buff[i] - 'a');
                    for(int offset = 1; offset < 26; offset ++) {//skip itself from 1
                        buff[i] = (char)((c + offset) % 26 + 'a');
                        target = String.valueOf(buff);
                        if(endSet.contains(target))// reach!
                            return step;
                        if(words.contains(target)) {// remove from words to make it visited
                            temp.add(target);
                            words.remove(target);
                        }
                    }
                    //Don't forget to recover it when switch to another char in the string !!!!!!
                    buff[i] = (char)(c + 'a');
                }
            }
            beginSet = temp;
        }
        return 0;
    }
	

}
