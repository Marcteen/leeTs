package leeTs.Easy;

public class _169_Majority_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int majorityElement(int[] nums) {
		int count = 0;
		int majorElement = 0;
		for(int i = 0; i < nums.length; i ++) {
			if(count == 0) {
				majorElement = nums[i];
				count ++;
			}
			else
				if(majorElement == nums[i])
					count ++;
				else
					count --;
		}
		return majorElement;
	}
}
