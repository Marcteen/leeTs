package leeTs.Medium;

public class _34_Search_for_a_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        if(nums.length == 0)
            return range;
        int low = 0, mid = 0, high = nums.length - 1;
        binarySearch:
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] > target)
                high = mid - 1;
            else
                if(nums[mid] < target)
                    low = mid + 1;
                else 
                    break binarySearch;
        }
        if(nums[mid] == target) {
            range[0] = range[1] = mid;
            if(mid > 0 && nums[mid - 1] == target) // check the left side
                range[0] = sideBinarySearch(nums, 0, mid - 1, -1, target);
            if(mid < nums.length - 1 &&  nums[mid + 1] == target)
                range[1] = sideBinarySearch(nums, mid + 1, nums.length - 1, 1, target);
        }
        return range;
    }
    
	public int sideBinarySearch(int nums[], int low, int high, int offset, int target) {// the offset use to differ the search in left and right part
        if(-1 == offset) {// It is left side
            if(nums[low] == target)
                return low;// A special case which will need check to ensure correct and save time
        }
        else // It is right side
            if(nums[high] == target)
                return high;
        // use another trick binary search for left side
        int mid = 0;
        while(low < high) { 
            if(-1 == offset)
                mid = low + (high - low) / 2 ;
            else
                mid = low + (high - low) / 2 + 1;// right side
                /* deviate the mid is another way to avoid stuck, it has no effect
                 * on correctness because if diviated to a greater one it will be
                 * reduce back in next iteration. Because we only differ in on bound
                 * in next, for instancee when deal with right side, it will help when
                 * low + 1 = high, makes new mid quals high other than low(for left
                 * side, mid equals to low is okay because low = mid + 1), and high
                 * is move with high = mid - 1, it has no way to stuck when mid == high,
                 * and with new equation of mid there is no way for mid = low either, so
                 * we don't have to worry low = mid may cause stack when mid = low. What
                 * more, using this trick we don't check the neighbour of mid when iterate.*/
            if(nums[mid] > target)// shrink to the right part, only possible in left side
                high = mid - 1;
            else 
                if(nums[mid] == target)// may locate on the final bound, differ in right and left side
                    if(-1 == offset)// left side, bound may be mid or somewhere > mid
                        high = mid;/* avoiding missing the ideal bound;(if don't move high here,
                        			no other case to move it..)*/
                    else
                        low = mid;

                else 
                    if(nums[mid] < target)// shrink to the left part, only possible in right side
                        low = mid + 1;
        }
        return low;
    }
}
