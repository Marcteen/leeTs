package leeTs.Medium;

public class _287_Find_the_Duplicate_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*use the linked loop search method, the values are treated
	 * as its following node's index*/
	public int findDuplicate(int[] nums) {
        if(null == nums || nums.length < 1)
            return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
