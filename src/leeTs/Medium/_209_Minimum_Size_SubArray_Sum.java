package leeTs.Medium;

import java.util.HashMap;

public class _209_Minimum_Size_SubArray_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
	}
	//Don't mistake the swtiching inequal condition in binary search!!! 
	public int minSubArrayLenBS(int s, int[] nums) {
        if(null == nums || nums.length == 0)
			return 0;
		int[] prefixSum = new int[nums.length + 1];
		for(int i = 1; i < prefixSum.length; i ++)
		    prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
		int start = 0, end = 1, minLength = Integer.MAX_VALUE;
		while(start < prefixSum.length) {
		    // find the smallest nonless-than prefix sum
		    end = binarySearch(prefixSum[start] + s, start + 1, prefixSum.length - 1, prefixSum);
		    if(end  == prefixSum.length)
		        break;
		    if(end - start < minLength)
		        minLength = end - start;//(eqaul to i - j + 1 with start-with-zero index)
		    start ++;
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    public int binarySearch(int target, int start, int end, int[] nums) {
        //we should find the index + 1 of first element with smllest-larger than accumulation
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            /*we may miss the real target now by assign high with mid - 1, but then nums[mid]
            must be less than target, so the low point will shift to high + 1 which indicate
            the real target!! and if the tail is smaller than target, low would step out of
            the range by 1*/
            if(nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
	
	// don't use the tail statement to achieve neat style too much!!!!
    public static int minSubArrayLen(int s, int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        int head = 0, tail = 0, sum = 0, minLength = Integer.MAX_VALUE, diff = 0;
        while(tail < nums.length) {
            for(; tail < nums.length && sum < s; sum += nums[tail++]);
            // in this case, we may have already find a shortest solution
            if(sum < s)
                break;
            for(; head < tail && sum >= s; sum -= nums[head++]);
            diff = tail - head + 1;
            if(diff < minLength)
                minLength = diff;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
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
