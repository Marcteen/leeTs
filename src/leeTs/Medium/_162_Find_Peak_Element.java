package leeTs.Medium;

import java.util.LinkedList;

public class _162_Find_Peak_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] nums) {
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
