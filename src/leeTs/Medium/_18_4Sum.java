package leeTs.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class _18_4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> c = new ArrayList<>(2);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums.length < 4)
            return result;
        Arrays.sort(nums);
        int bound = nums.length - 1;
        int frontBound = bound - 2;
        for(int i = 0; i < frontBound; i ++){// since the nums[] is in order, we must make use of it.
            if(i > 0 && nums[i] == nums[i - 1]) // skip the duplication
                continue;
            if(nums[i] + nums[bound] * 3 < target) // skip the number that is too small
                continue;
            if(nums[i] * 4 > target)// no other solution exists
                break;
            if(nums[i] * 4 == target)
                if(nums[i + 3] == nums[i]) {// very coinsident, we have suit number of duplication
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[i], nums[i], nums[i]}));
                    i += 4;
                    continue;
                }
            // we found a num that may make up an solution, forward to an divided subproblem
            threeSuming(nums, i + 1, target - nums[i], nums[i], result);
        }
        return result;
    }
    
    public void threeSuming(int[] nums, int start, int target, int prefix, List<List<Integer>> result) {
        int bound = nums.length - 1;
        int frontBound = bound - 1;
        for(int i = start; i < frontBound; i ++) {
            if(i > start && nums[i] == nums[i - 1])
                continue;
            if(nums[i] + nums[bound] * 2 < target)
                continue;
            if(nums[i] * 3 > target)
                break;
            if(nums[i] * 3 == target)
                if(nums[i] == nums[i + 2]) {
                    result.add(Arrays.asList(new Integer[]{prefix ,nums[i], nums[i + 1], nums[i + 2]}));
                    i += 3;
                    continue;
                }
            // we again found a num that may make up an solution, forward to an divided subproblem
            twoSuming(nums, i + 1, target - nums[i], prefix, nums[i], result);
        }
    }
    
    public void twoSuming(int[] nums, int start, int target, int prefix, int second, List<List<Integer>> result) {
        int left = start, right = nums.length - 1, sum;
        while(left < right) {
            sum = nums[left] + nums[right];
            if(sum > target)
                while(left <= right && nums[-- right] == nums[right + 1]);
            else
                if(sum < target)
                    while(left <= right && nums[++ left] == nums[left - 1]);
                else {
                    result.add(Arrays.asList(new Integer[]{prefix, second, nums[left], nums[right]}));
                    while(left <= right && nums[-- right] == nums[right + 1]);
                    while(left <= right && nums[++ left] == nums[left - 1]);
                }
        }
    }
	
}
