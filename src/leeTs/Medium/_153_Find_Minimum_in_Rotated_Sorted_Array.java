package leeTs.Medium;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMin(int[] nums) {
        //In case that there is only on element
        if(nums[0] <= nums[nums.length - 1])
            return nums[0];
        int low = 0, high = nums.length - 1, mid = 0;
        while(low < high) {
            mid = low + (high - low) / 2;
            if(nums[low] <= nums[mid] && nums[mid] < nums[high]) {
               break;
            }
        /*we locate at the right part, and mid may just locates at the target!!!
        for we want low and high to meet at the target, we set high = mid, there
        is no way to get stuck because mid == high only if high == low*/
            if(nums[mid] < nums[low])
                high = mid;
            else if(nums[mid] > nums[high])
                low = mid + 1;
        }
        //don't mistake the
        return nums[low];
    }
}
