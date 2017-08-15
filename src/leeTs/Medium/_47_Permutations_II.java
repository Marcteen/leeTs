package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Arrays;


public class _47_Permutations_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        BitSet taken = new BitSet(nums.length);
        if(null == nums || 0 == nums.length)
            return result;
        Arrays.sort(nums); // we use order and adjacent to maintain unique permutation
        permute(nums, taken, permutation, result);
        return result;
    }
	/* with the slightly-adjusted trick which rise the array a little everytime to get
	 * the ascending permutation collection*/
	public List<List<Integer>> permuteAscend(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == nums || 0 == nums.length)
            return result;
        Arrays.sort(nums); // we use order and adjacent to maintain unique permutation
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for(int ni : nums)
            list.add(ni);
        result.add((ArrayList<Integer>)list.clone());
        int bound = 0;
        int newGreater = 0;
        while(true) {
            for(bound = nums.length - 1; bound > 0 && list.get(bound) <= list.get(bound - 1); bound --);// with equal for duplication case !!! It can push bound to the very left top in a unincreasing subarray with duplicated prefix, otherwise the following swaping will make the whole array un changed, which ends up with infinite duplication.
            
            if(0 == bound)
                break;// No smaller permutation
            
            // make it a litte bit larger
            for(newGreater = bound + 1; newGreater < nums.length && list.get(newGreater) > list.get(bound - 1); newGreater ++);
            swap(list, bound - 1, newGreater - 1);
            reverseInOrder(list, bound, nums.length - 1);
            
            result.add((ArrayList<Integer>)list.clone());
        }
        return result;
    }
    
    public void reverseInOrder(ArrayList<Integer> list, int start, int end) {
        while(start < end) {
            swap(list, start, end);
            start ++;
            end --;
        }
    }
    
    public void swap(ArrayList<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    public void permute(int[] nums, BitSet taken, List<Integer> permutation, List<List<Integer>> result) {
        if(permutation.size() == nums.length)
            result.add(new ArrayList<Integer>(permutation));// need copy, and List is not cloneable, though ArrayList is cloneable.
        else {
            for(int i = 0; i < nums.length; i ++) {// because order matter in permutation, scan all everytime
                /*because the duplicate elements are adjacent, and we don't keep track of the element that
                 * already has been used by this layer, if we found nums[i] == nums[i - 1], there may be
                 * two case: the former are used by last layer or use by itself.For the second case,
                 * taken.get(i - 1) must be false, otherwise, we can take it just because we didn't use
                 * this value in former iteration in this layer. We don't continue(skip it) when i == 0 because it is the beginning of the layer,
                 * no value used at all. And last, if taken.get(i) is not true, we can use it.*/
            	if(i > 0 && nums[i] == nums[i - 1] && taken.get(i - 1) || taken.get(i))
                    continue;/*In this way, the duplicated element can only be load in one order, so if we take
                    the first dup in kth layer, when backtrack to it, there is no way that it can take another
                    dup (which will cause duplicated permutation).*/
                    taken.set(i);
                    permutation.add(nums[i]);
                    permute(nums, taken, permutation, result);
                    taken.clear(i);
                    permutation.remove(permutation.size() - 1);
                    /*if nums[i] == nums[i - 1], taken.get(i - 1) == false and i > 0, we have already use
                     * nums[i] in this layer, and this rule is sufficient to skip all duplicated number
                     * in sorted array! And finally, it is permutation, not a combination!!!*/
            }
        }
    }
}
