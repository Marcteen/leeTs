package leeTs.Hard;

public class _45_Jump_Game_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*a concise greedy solution*/
	public int jumpGreedy(int[] nums) {
        if(null == nums)
            return 0;
        int frontier = 0, stepBound = 0, step = 0;
        for(int i = 0; i < nums.length - 1; i ++) {
            /*keep track of the furthest index it can reach now*/
            frontier = Math.max(frontier, nums[i] + i);
            /*say the last frontier - stepBound, is generate by i_old, we reach
            i_old + nums[i_old] and it is not the end, so we actually
            need to jump from i_old by some value less than nums[i_old] (actually
            we select the one with current furthest frontier implicitly, because
            we wish it can jump to the end within its range),that means from i_old,
            we can't reach the end by one jump, so we increase the step by one.
            Note that i should not be able to reach nums.length - 1 because if
            nums.length - 1 == stepBound, there is actually no need to increase the step!!!!*/
            if(i == stepBound) {
                step ++;
                stepBound = frontier;
            }
        }
        return step;
    }
	/*Straightforward but not fast enough*/
	public int jump(int[] nums) {
        if(null == nums || 2 > nums.length)
            return 0;
        int[] cost = new int[nums.length];
        int last = nums.length - 1;
        int minCost = 0;
        for(int i = nums.length - 2; i >= 0; i --) {
            if(nums[i] + i >= last)
                cost[i] = 1;
            else if(nums[i] == 0)
            	/*don't use the Integer.MIN_VALUE here for
            	 * it will overflow when add positive, so
            	 * we use a -1 as unreachable sign and
            	 * do check before we sum up the step*/
                cost[i] = -1;
            else {
                minCost = Integer.MAX_VALUE;
                for(int j = 1; j <= nums[i]; j ++) {
                    if(cost[i + j] > 0 && 1 + cost[i + j] < minCost) {
                        minCost = 1 + cost[i + j];
                        cost[i] = minCost;
                    }
                }
            }
        }
        return cost[0];
    }

}
