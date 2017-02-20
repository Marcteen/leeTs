package leeTs.Medium;

public class _80_Remove_Duplicates_from_Sorted_Array_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length < 2)
            return nums.length;
        boolean duplicated = false;
        int dup = 0, pos = 1;
        for(; pos < nums.length; pos ++) {
            nums[pos - dup] = nums[pos];
            if(nums[pos- dup] == nums[pos - dup - 1]) {
                if(!duplicated)
                    duplicated = true;
                else {
                    dup ++;
                }
            }
            else
                duplicated = false;
        }
        return pos - dup;
    }
}
