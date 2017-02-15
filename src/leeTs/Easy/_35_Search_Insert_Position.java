package leeTs.Easy;

public class _35_Search_Insert_Position {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        while(low < high) {
            mid = low + (high - low) / 2;// mid will never equal to high except for high == low
            if(nums[mid] < target)
                low = mid + 1;
            else
                if(nums[mid] > target)
                    high = mid;// because we must avoid missing the ideal pos;
                else {
                    return mid;
                }                                   
        }
        if(nums[low] >= target)// need correction for elements at nums's two bound !
            return low;
        else
            return low + 1;
    }
	public int searchInsertNaive(int[] nums, int target) {
        int insertPos = 0;
        for(insertPos = 0; insertPos < nums.length && nums[insertPos] < target; insertPos ++);
        return insertPos;
    }

}
