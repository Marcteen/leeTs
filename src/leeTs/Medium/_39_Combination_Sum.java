package leeTs.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Map;

public class _39_Combination_Sum {
/*https://discuss.leetcode.com/topic/46161/a-general-approach-to-
 * backtracking-questions-in-java-subsets-permutations-combination-
 * sum-palindrome-partitioning*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1, 2, 5};
		int[] b = new int[]{1, 2, 5};
		System.out.println(Arrays.equals(a, b));
		TreeMap<Integer, Integer> map = new TreeMap<>();
		TreeSet<ArrayList<Integer>> set = new TreeSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		map.put(2, 3);
		map.put(1, 5);
		map.put(7, 5);
		map.put(3, 6);
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			Iterator iterator1 = map.entrySet().iterator();
			while(iterator1.hasNext())
				System.out.println(" " + iterator1.next());
		}
		
		int[] nums = new int[]{1, 2};
		List<List<Integer>> result = combinationSumNaive(nums, 4);
	}
	// Weird, recursive mothod is much quicker@@$!#$!!!!!@#$#$%^$^&#@
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(); // form the solution from 1 to target, not so relevant to candidates
        if(null == candidates || 0 == candidates.length)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> newList = null;
        for(int subTarget = 1; subTarget <= target; subTarget ++) { // dp is one-way done, no re-run needed!!!!
            newList = new ArrayList<>();
            for(int j = 0; j < candidates.length && candidates[j] <= subTarget; j ++) {// we must use a existing candidate to form combination
                if(candidates[j] == subTarget) {// no need to find complement
                    newList.add(Arrays.asList(new Integer[]{subTarget}));// add a array to the list of array
                }
                else {
                    for(List<Integer> complement : dp.get(subTarget - candidates[j] - 1)) { // the index is smaller by one
                        //to avoid duplication, we need to keep it sorted, very concise!!!!!!
                        if(candidates[j] <= complement.get(0)) {// smaller candidates will cover bigger one, and keep combination sorted
                            List<Integer> combine = new ArrayList<>();
                            combine.add(candidates[j]);
                            combine.addAll(complement);
                            newList.add(combine);
                        }
                    }
                }
                
            }
            dp.add(newList);// add it any way to avoid null in impossible combination, make algorithm general
        }
        return dp.get(target - 1);
    }
	
	public static List<List<Integer>> combinationSumNaive(int[] candidates, int target) {
        TreeMap<Integer, HashSet<List<Integer>>> dp = new TreeMap<>();
        boolean added = true;
        Iterator<List<Integer>> src1 = null, src2 = null;
        List<Integer> s1 = null;
        List<Integer> newCandidate = null;
        while(added) {
            added = false;
            for(int cadt : candidates) {
                if(cadt <= target)
                    if(!dp.containsKey(cadt)) {
                        HashSet<List<Integer>> set = new HashSet<>();
                        set.add((List<Integer>)Arrays.asList(new Integer[]{cadt}));
                        dp.put(cadt, set);
                        added = true;
                    }
                    else {
                        if(target - cadt >= cadt) {// otherwise they must be cover by the front elements
                            for(int i = cadt; cadt + i <= target; i ++)// built up more candidates
                                if(dp.containsKey(i)) {
                                    src1 = dp.get(cadt).iterator();
                                    while(src1.hasNext()) {
                                        s1 = src1.next();
                                        src2 = dp.get(i).iterator();// must put inside the outter loop, otherwise it can only traverse once
                                        while(src2.hasNext()) {
                                            newCandidate = new ArrayList<Integer>();
                                            newCandidate.addAll(s1);
                                            newCandidate.addAll(src2.next());
                                            Collections.sort(newCandidate);
                                            if(dp.containsKey(cadt + i)) {
                                                if(dp.get(cadt + i).add(newCandidate))
                                                    added = true;
                                            }
                                            else {// brand new one candidate
                                                dp.put(cadt + i, new HashSet<List<Integer>>());
                                                dp.get(cadt + i).add(newCandidate);
                                                added = true;
                                            }
                                        }
                                    }
                                }
                        }
                        
                    }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        Set res = dp.get(target);
        if(null != res)
            result.addAll(res);
        return result;
    }
}
