package leeTs.Easy;

public class _27_Remove_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeElement(int[] nums, int val) {
        int result = 0;
        for(int i = 0;i < nums.length;i ++) {
        	if(nums[i] != val) {
        		nums[result] = nums[i];
        		result ++;
        	}
        }
        return result;
    }
}
