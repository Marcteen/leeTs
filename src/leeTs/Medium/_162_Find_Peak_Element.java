package leeTs.Medium;

import java.util.LinkedList;

public class _162_Find_Peak_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// imaging use the low and high to climb slope toward the peak, it is logn
	public int findPeakElement(int[] nums) {
        if(null == nums)
            return 0;
        int low = 0, high = nums.length - 1, mid = 0;
        while(low < high) {
            mid = low + (high - low) / 2;
            // search the potential peak in the front, because it must exist
            if(nums[mid] < nums[mid + 1])
                low = mid + 1;
            // search the potential peak behind
            else if(nums[mid] > nums[mid + 1])
                high = mid;
        }
        return low;
    }
	
	//correct but no efficient, it is nlogn, not logn
	public int findPeakElementMerging(int[] nums) {
        LinkedList<int[]> merging = new LinkedList<>();
        int size = 0, former[] = null, latter[] = null;
        // merging from bottom to up
        for(int i = 0; i < nums.length; i ++) {
            merging.offer(new int[]{i, i});
        }
        while(merging.size() > 1) {
            size = merging.size();
            for(int i = 1; i < size;) {
                former = merging.poll();
                latter = merging.poll();
            // while merging, if we found two inner bound form a peak, we can return it immediately
                if(nums[former[1]] > nums[former[0]] && nums[former[1]] > nums[latter[0]])
                    return former[1];
                else if (nums[latter[0]] > nums[latter[1]] && nums[latter[0]] > nums[former[1]])
                    return latter[0];
            // else merge them
                else {
                    former[1] = latter[1];
                    merging.add(former);
                }
                i += 2;
            }
        }
        former = merging.poll();
        return nums[former[0]] > nums[former[1]] ? former[0] : former[1];
    }
}
