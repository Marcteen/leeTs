package leeTs.Easy;

public class _26_Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int removeDuplicates(int[] nums) {
		if(0 == nums.length)
			return 0;
		else {
			int numNoDuplicates = 1;
			for(int i = 1;i < nums.length;i ++) {
				if(nums[i] != nums[i - 1]) {
					nums[numNoDuplicates] = nums[i];
					numNoDuplicates ++;
				}
			}
			return numNoDuplicates;
		}
		
	}
}
