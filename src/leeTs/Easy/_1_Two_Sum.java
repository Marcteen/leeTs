package leeTs.Easy;

import java.util.HashMap;

public class _1_Two_Sum {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.println(String.format("The result is [%d, %d], %d + %d = %d", result[0], result[1], nums[result[0]], nums[result[1]], nums[result[0]] + nums[result[1]]));
	}
	//Found two index of which the values' sum equals to the target
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> checked = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            if(checked.containsKey(target - nums[i])) {
                return new int[]{checked.get(target - nums[i]), i};
            }
            else
                checked.put(nums[i], i);
        }
        return null;
    }
}
