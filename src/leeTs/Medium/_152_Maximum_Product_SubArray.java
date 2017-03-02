package leeTs.Medium;

public class _152_Maximum_Product_SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProduct(int[] nums) {
        if(null == nums)
            return 0;
        int max = nums[0];
        int prevMin = nums[0];
        int prevMax = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] > 0) {
                curMax = Math.max(nums[i], nums[i] * curMax);
                curMin = Math.min(nums[i], nums[i] * curMin);
            }
            else {
                curMin = Math.max(nums[i], nums[i] * curMax);
                curMax = Math.min(nums[i], nums[i] * curMin);
            }
            if(curMax > max)
                max = curMax;
        }
        return max;
    }

}
