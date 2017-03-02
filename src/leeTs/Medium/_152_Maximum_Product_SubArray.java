package leeTs.Medium;

public class _152_Maximum_Product_SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Symbol matters in product, so when meet a minus one, some
	 * minus min would turn to a max, so using the dp, we keep track
	 * of max and min at each step*/
	public int maxProduct(int[] nums) {
        if(null == nums)
            return 0;
        int max = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        int temp = 0;
        for(int i = 1; i < nums.length; i ++) {
        /*if they are all positive, the product of all is the max, but
         * when given with some minus one, we would suffer sudden change in
         * value in case of their symbol.When we first meet a minus one, the absolute
         * value still increase but it become a small number. If we get a minus following
         * number we can make current min the greatest. So each term we should keep both
         * min and max*/
            if(nums[i] > 0) {
                curMax = Math.max(nums[i], nums[i] * curMax);
                curMin = Math.min(nums[i], nums[i] * curMin);
            }
            else {
                temp = curMin;
                curMin = Math.min(nums[i], nums[i] * curMax);
                curMax = Math.max(nums[i], nums[i] * temp);
            }
            if(curMax > max)
                max = curMax;
        }
        return max;
    }

}
