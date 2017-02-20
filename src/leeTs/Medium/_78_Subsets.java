package leeTs.Medium;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
	
	public static void main(String[] args) {
		int n = -123;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(-n));
	}
	/* Use a int to indicate the combination, noted that for n numbers
	 * the size of the power set is 2^n, that is from 0 to 2^n - 1, we use each
	 * number in bits.*/
	public List<List<Integer>> subsetsInBit(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        if(null == nums || 0 == nums.length)
            return result;
        int total = (int)Math.pow(2, nums.length);
        for(int i = 1; i < total; i ++)
            result.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i ++)// for every candidate number
            for(int j = 0; j < total; j ++)// for every subset
            	/*for j = 3 = 101, so the number indicated by first and third
            	 * bits must be selected, that is for i = 0 and 2*/
                if(1 == ((j >> i) & 1))
                    result.get(j).add(nums[i]);
        return result;
    }
	
	// Note that this is power set, not a "specific length combination"
	/* Generate the power set from a empty subset, each time
	 * we form new ones by add a new element to existing ones
	 * and keep the former one untouched.*/
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        if(null == nums || 0 == nums.length)
            return result;
        int size = 0;
        ArrayList<Integer> newList = null;
        for(int ni : nums) {
            size = result.size();
            for(int i = 0; i < size; i ++) {
                newList = new ArrayList(result.get(i));
                newList.add(ni);
                result.add(newList);
            }
        }
        return result;
    }
}
