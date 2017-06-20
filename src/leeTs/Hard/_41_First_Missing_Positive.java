package leeTs.Hard;

public class _41_First_Missing_Positive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//try to move number to the right index according to its value - 1
	public int firstMissingPositive(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 1;
        int j = 0;
        for(int i = 0; i < nums.length; i ++) {
            j = i;
            /*just move the positive number, and make sure its value - 1
             * doesn't exceed the index range. One lasts, if the target
             * index has contains the same value, we don't need to swap
             * them, actually it can indicate a missing value eventually*/
            while(nums[j] > 0 && j + 1 != nums[j] && nums[j] - 1 < nums.length && nums[nums[j] - 1] != nums[j]) {
                swap(nums, j, nums[j] - 1);
            }
        }
        j = -1;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != i + 1) {
                j = i;
                break;
            }
        }
        /*if j is still -1, it means the last number is missing,
         * or the smaller number, which should be one larger than
         * the index*/
        return j >= 0 ? j + 1 : nums.length + 1;
    }
    public static void swap(int[] nums, int foo, int bar) {
        nums[foo] ^= nums[bar];
        nums[bar] ^= nums[foo];
        nums[foo] ^= nums[bar];
    }
}
