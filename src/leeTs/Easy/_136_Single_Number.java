package leeTs.Easy;

public class _136_Single_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int singleNumber(int[] nums) {
		int result = 0;
		for(int i = 0; i < nums.length; i ++) {
			result = result ^ nums[i];
		}
		return result;
	}
}
