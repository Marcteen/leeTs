package leeTs.Medium;

import java.util.Comparator;

public class _55_Jump_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*Use dp, extend the path from tail to head, for ith index, we compare its 
	 * step with the require jump in the right part(start from 1 with only the last
	 * index), if ith has enough step, after add it to the right part, the require jump
	 * reset to 1 (because if i - 1 th has 1 step, it can reach ith and to the final index
	 * ), otherwise, the require jump will increase by 1(skip this unreachable node)*/
	public boolean canJump(int[] nums) {
        if(null == nums || nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;
        int require = 1;
        for(int i = nums.length - 2; i > 0; i --) {
            if(nums[i] < require)
                require ++;
            else
                require = 1;
        }
        return nums[0] >= require ? true : false;
    }

}
