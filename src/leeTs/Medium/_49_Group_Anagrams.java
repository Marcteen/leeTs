package leeTs.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class _49_Group_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "oooooo".toCharArray();
		char[] b = "oooooo".toCharArray();
		System.out.println(a.equals(b));
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> collect = new HashMap<>();
        char[] content = null;
        String key = null;
        ArrayList<String> newList = new ArrayList<>();
        for(String str : strs) {
            content = str.toCharArray();
            Arrays.sort(content);
            key = String.valueOf(content);/* Array is not comparable, here 
            cast it back to String is faster than use a ArrayList<Character> as key*/
            if(collect.containsKey(key))
                collect.get(key).add(str);
            else {
                newList = new ArrayList<>();
                newList.add(str);
                collect.put(key, newList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : collect.entrySet())
        	result.add(entry.getValue());
        return result;
    }

}
