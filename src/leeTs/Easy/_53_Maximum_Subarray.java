package leeTs.Easy;

public class _53_Maximum_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*With dp, we need to decompose it in a easy-handled way,
    grow the array in length is a good choice, but still need
    other constrain to make it clear. We can add taking the ith
    elements as the tail of the max num, make it less flexible
    but still enough to cover all case. Just because every combination
    has a tail element. Simply add ith elements into consideration,
    the max Sum may not contain ith, but it should be handle by earlier
    step rather than this ith one. Noted that, at step i, we only need
    to take care of near occcasion, not the very former cases!!!!!!!*/
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            nums[i] = nums[i - 1] > 0 ? nums[i] + nums[i - 1] : nums[i];
            if(nums[i] > max)
                max = nums[i];
        }
        return max;
    }

}
