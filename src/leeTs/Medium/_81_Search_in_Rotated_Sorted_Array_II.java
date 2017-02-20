package leeTs.Medium;

public class _81_Search_in_Rotated_Sorted_Array_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean search(int[] nums, int target) {
        if(null == nums || 0 == nums.length)
            return false;
        int low = 0, high = nums.length - 1, mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return true;
            /*for 1121111 and 222221222, the euqlity will make it wrong*/
            if(nums[low] < nums[mid] && nums[mid] < nums[high]) {// into a regular BS
                if(nums[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            /*Here we pass the [low]<[mid]<[high], and we must take care of all the remaing case, except both equal,
            there are cases consist of equal and other inversed unequal*/
            /* When [mid] > [low], the left part must be in order. When [mid] == [low], we skip the [mid] == [low]
            case and leave it for the final branch; if [mid] > [high], it still the same with last "when"; if [mid] < [high],
            we have [low]=[mid]<[high], it must be a regular BS case, otherwise, mid can't be equal to low, but it should
            have same shrink patter with next if-else branch.*/
            else if(nums[mid] > nums[low] || nums[mid] > nums[high]) {
                if(nums[mid] > target && target >= nums[low])// the left side is sure to be in order, and target is there
                        high = mid - 1;
                    else
                        low = mid + 1;
            /* When [mid] < [high], the right part must be in order. When [mid] == [high], we skip the [mid] == [low]
            case and leave it for the final branch; if [mid] < [low], it still the same with last "when"; if [mid] > [low],
            we have [low]<[mid]=[high], it must be a regular BS case, otherwise, mid can't be equal to high, but it should
            have same shrink patter with last if-else branch.*/
            } else if(nums[mid] < nums[low] || nums[mid] < nums[high]) {// the right side is sure in order
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else /* here both equal, so shrink it, both high -- and low ++ work fine(because no
                    info to determine which is better!!!!!!!!!!).*/
                low ++;
        }
        return false; // when low == high, must not found to reach here;
    }
}
