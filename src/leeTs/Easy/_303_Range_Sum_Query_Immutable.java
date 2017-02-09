package leeTs.Easy;

public class _303_Range_Sum_Query_Immutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] sums;
	
	public void NumArray(int[] nums) {
		sums = new int[nums.length];
		sums[0] = nums[0];
		for(int i = 1; i < nums.length; i ++)
			sums[i] = nums[i] + sums[i - 1];
	}
	
	public int sumRange(int i, int j) {
		return i > 0 ? sums[j] - sums[i - 1] : sums[j];
	}
	
}
