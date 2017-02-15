package leeTs.Medium;

public class _33_Search_in_Rotated_Sorted_Array {
/*An more important trick, the element behind the pivot must smaller than
 *nums[0], so if we found a number smaller than nums[0], we can treat as if
 *it is big than nums[0], just pretend adding an infinite number to them*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// whatever, the potential targets lies in a sorted part between original BS mid and the pivot!
    public int searchAdvanced(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high) {// if equal not allowed, we would check if low/high points to the real target 
            mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;// For the god sake, very coincident, kind of important !!!
            if(nums[mid] <= nums[high] && nums[mid] >= nums[low]) {// We may fit into an well sorted part
                if(target > nums[mid])// Without the plus/minus one, they would stuck at low + 1 = high
                    low = mid + 1;// don't mistake the correponding assignment
                else
                    if(target < nums[mid])
                        high = mid - 1;
                    else
                        return mid;
            }
            else 
                if(nums[mid] < nums[high]) {// Its right side is well sorted
                    if(target < nums[mid])// Target not locates at right, so it is not certain
                        high = mid - 1;
                    else // Must take care of the equal, target may be at bound!
                        if(target <= nums[high]) // Locates in a well sorted part!
                            low = mid + 1;
                        else
                            high = mid - 1;// Not certain too
                }
                else {// Its left side is well sorted
                    if(target > nums[mid])// Target not located at left, so it is not certain
                        low = mid + 1;
                    else
                        if(target >= nums[low])// Locates in a well sorted part!
                            high = mid - 1;
                        else
                            low = mid + 1; // Not certain too
                }
        }
        return -1;
    }
    //A good understanding of binary search anyway
    /**/
    int searchTrickyBS(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        /* Proof by contradiction that mid < hi must always hold, and: 
         * if mid==hi, then lo == hi and loop would have been terminated.
         */
        /* Understanding: We use BS and correct its order ( We should have
         * lo < mid < hi in elements), and if lo/hi is violated, we need to
         * change hi/lo for a more narrow range of the min elements. Noted
         * that mid may just be at the min for chances, at this time lo must
         * be violated, so we need to set hi = mid for not missing it. 
         */
        /* But in an orinary BS, we need both bound narrow by 1 from mid to
         * ensure breaking the condition of lo <= high when there is only single
         * unwanted element in array or they are next to each other and one of
         * them is mid and unwanted.*/
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
	
	public int searchNaive(int[] nums, int target) {
        if(nums.length == 0)
            return - 1;
        else {
            int state = 0;
            search:
            for(int i = 0, count = 0; count < nums.length; count ++) {
                if(nums[i] > target) {
                    if(0 == state)
                        state = 1;
                    else
                        if(1 != state)
                            return -1;
                    i += nums.length - 1;
                    i %= nums.length;
                }
                else
                    if(nums[i] < target) {
                        if(0 == state)
                            state = 1;
                        else
                            if(-1 == state)
                                return -1;
                        i += 1;
                        i %= nums.length;
                    }
                    else {
                        return i;
                    }
                        
            }
            return -1;
        }
    }

}
