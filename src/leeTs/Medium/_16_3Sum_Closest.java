package leeTs.Medium;

import java.util.Arrays;

public class _16_3Sum_Closest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDest = Integer.MAX_VALUE;
        int targetSum = 0;
        int dest = 0;
        int available = nums.length - 3;
        int front, tail;
        for(int i = 0; i <= available;) {
            front = i + 1;
            tail = nums.length - 1;
            while(front < tail) {
                dest = nums[i] + nums[front] + nums[tail] - target;// don't mistaken the pos!
                if(Math.abs(dest) < minDest) {
                    minDest = Math.abs(dest);
                    targetSum = dest + target;
                }
                if(dest > 0)
                    while(tail > front && nums[-- tail] == nums[tail + 1]);
                else
                    if(dest < 0)
                        while(front < tail && nums[++ front] == nums[front - 1]);
                        else
                            return targetSum;
            }
            while(i <= available && nums[++ i] == nums[i - 1]);
        }
        return targetSum;
    }
}
