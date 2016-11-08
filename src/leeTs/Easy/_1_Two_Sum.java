package leeTs.Easy;

public class _1_Two_Sum {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.println(String.format("The result is [%d, %d], %d + %d = %d", result[0], result[1], nums[result[0]], nums[result[1]], nums[result[0]] + nums[result[1]]));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] targetIndex = new int[2];
		for(int i = 1; i < nums.length; i ++) {
			for(int j = 0; j < i; j ++) {
				if(nums[i] + nums[j] == target) {
					targetIndex[0] = j;
					targetIndex[1] = i;
					return targetIndex;
				}
			}
		}
		return targetIndex;
	}
}
