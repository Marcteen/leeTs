package leeTs.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class _40_Combination_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(null == candidates || candidates.length == 0)
            return new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curCombination = new ArrayList<>();
        combination(candidates, 0, curCombination, target, result);
        return result;
    }
    
    public void combination(int[] candidates, int start, ArrayList<Integer> curCombination, int left, List<List<Integer>> result) {
        if(left > 0) {
            for(int i = start; i < candidates.length; i ++) {
                if(i == start || candidates[i] != candidates[i - 1]) {// no dup in same layer, but allowed in adjacent layer
                    curCombination.add(candidates[i]);
                    combination(candidates, i + 1, curCombination, left - candidates[i], result);
                    curCombination.remove(curCombination.size() - 1);
                }
            }
        }
        else if(0 == left) {
            result.add((List)curCombination.clone());
        }
    }
	
}
