package leeTs.Medium;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_Letter_Combination_Of_a_Phone_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public List<String> letterCombinations(String digits) {
		LinkedList<String> pool = new LinkedList<>();
		if(pool.equals(""))
			return pool;
		String[] cmap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		pool.add("");
		int bound = digits.length();
		String cur = "";
		for(int i = 0; i < bound; i ++) {
			while(pool.peek().length() == i) { // the fifo property means it still needs extending, otherwise turns to next digit or terminates!
				cur = pool.poll();// get the string for extending
				for(char c : cmap[Character.getNumericValue(digits.charAt(i))].toCharArray())
					pool.offer(cur + c);
			}
		}
		return pool;
	}
	
	public List<String> letterCombinationsNaive(String digits) {
        HashMap<Character, char[]> cmap = new HashMap<>();
        cmap.put('2', new char[]{'a', 'b', 'c'});
        cmap.put('3', new char[]{'d', 'e', 'f'});
        cmap.put('4', new char[]{'g', 'h', 'i'});
        cmap.put('5', new char[]{'j', 'k', 'l'});
        cmap.put('6', new char[]{'m', 'n', 'o'});
        cmap.put('7', new char[]{'p', 'q', 'r', 's'});
        cmap.put('8', new char[]{'t', 'u', 'v'});
        cmap.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> result = new ArrayList<>();
        if(null == digits | digits.equals(""))
            return result;
        tarverseCombination(digits, cmap, 0, "", result);
        return result;
    }
    
    public void tarverseCombination(String digits, HashMap<Character, char[]> cmap, int pos, String content, List<String> result) {
        if(digits.length() - 1 == pos) {
            for(char c : cmap.get(digits.charAt(pos)))
                result.add(content + c);
        }
        else
            for(char c : cmap.get(digits.charAt(pos)))
                tarverseCombination(digits, cmap, pos + 1, content + c, result);
    }
}
