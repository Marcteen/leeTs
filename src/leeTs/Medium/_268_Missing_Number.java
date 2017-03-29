package leeTs.Medium;

import java.util.Arrays;

public class _268_Missing_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*using the sum of them*/
	public int missingNumberSum(int[] nums) {
		if(null == nums || 0 == nums.length)
            return 0;
        int sum = nums.length * (nums.length + 1) / 2;
        for(int ni : nums)
            sum -= ni;
        return sum;
	}
	
	/*this problem means the array should always start from 0 to N*/
	/*Use the xor of elements and their value*/
	public int missingNumberXor(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        /*we use the length as initial number, because it may
        lacks the greatest number, otherwise, the greatest is
        eliminate by the length*/
        int xor = nums.length;
        for(int i = 0; i < nums.length; i ++) {
            xor ^= i;
            xor ^= nums[i];
        }
        return xor;
    }
	/*Binary search with ordering, noted that the initial value of */
	public int missingNumberBS(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        Arrays.sort(nums);
        /*we need to set high = length, because if there is only one
        element, it can enable the only comparison. As for other case,
        it remains the same*/
        int low = 0, high = nums.length, mid = 0;
        while(low < high) {
            mid = low + (high - low) / 2;
            if(nums[mid] == mid)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
	
	public int missingNumberNaive(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        Arrays.sort(nums);
        int number = 0;
        for(int ni : nums) {
            if(ni != number)
                break;
            number ++;
        }
        return number;
    }

}
