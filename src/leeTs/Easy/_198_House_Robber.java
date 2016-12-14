package leeTs.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class _198_House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int robIterative(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];
		for(int i = 1; i <= nums.length; i ++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); // If we don't rob i, then i - 1 can be deal with in both way
			dp[i][1] = nums[i - 1] + dp[i - 1][0];// we do rob i, then i - 1 must not be robbed.
		}
		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}
	
	public int robIterativeBetter(int[] nums) {
		int preRobbed = 0;
		int preNotRobbed = 0;
		int tempPreRobbed = 0;
		for(int i = 0; i < nums.length; i ++) {// the next value is only depend on the one right before it.
			tempPreRobbed = preRobbed;
			preRobbed = nums[i] + preNotRobbed;
			preNotRobbed = Math.max(tempPreRobbed, preNotRobbed);
		}
		return Math.max(preRobbed, preNotRobbed);
	}
	public int rob(int[] nums) {
        if(0 == nums.length)
        return 0;
        else {
            int result = 0;
    		int[] dp = new int[nums.length];
    		for(int i = 0; i < nums.length; i ++)
    			dp[i] = -1;
    		result = getMax(nums, dp, 0);
    		return result;
        }
	}
	
	public int getMax(int[] nums, int[] dp, int step) {
		int max = 0;
		if(step == nums.length - 1) {// an boundary for determine the maximum
			max = nums[step];
		}
		else {// not an bound
			if(-1 != dp[step])// an problem already computed
				max = dp[step];
			else {// not computed
				if(step == nums.length - 2)
					max = Math.max(nums[step], getMax(nums, dp, step + 1));
				else
					max = Math.max(nums[step] + getMax(nums, dp, step + 2), getMax(nums, dp, step + 1));
				dp[step] = max;
			}
		}
		return max;
	}
}
