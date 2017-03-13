package leeTs.Medium;

import java.util.HashMap;

public class _209_Minimum_Size_SubArray_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
	}
	
	public int minSubArrayLen(int s, int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        int head = 0, tail = 0, sum = 0, minLength = Integer.MAX_VALUE, diff = 0;
        for(; tail < nums.length; tail ++) {
            for(; tail < nums.length && sum < s; sum += nums[tail], tail ++);
            for(; head < tail && sum >= s; sum -= nums[head], head ++);
            diff = tail - head + 1;
            if(diff < minLength)
                minLength = diff;
        }
        return minLength;
    }
	// It is too slow
	public int minSubArrayLenWithPrefixSum(int s, int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        int minLength = Integer.MAX_VALUE, diff = 0, curLength = 0, accSum = 0;
        boolean found = false;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(nums[0], 0);
        for(int i = 0; i < nums.length; i ++) {
            accSum += nums[i];
            prefixSum.put(accSum, i);
            if(accSum >= s) {
                found = true;
                if(i + 1 < minLength)
                    minLength = i + 1;
                // don't mistaken the order or just take the absolute value
                diff = accSum - s;
                // there are all positive numbers, so just find the nearest prefix diff
                while(diff > 0) {
                    if(prefixSum.containsKey(diff)) {
                        curLength = i - prefixSum.get(diff);
                        // found one, the rest can only be longer for the positive array;
                        if(curLength < minLength) {
                            minLength = curLength;
                            break;
                        }
                    }
                    diff --;
                }
            }
        }
        return found ? minLength : 0;
    }

}
