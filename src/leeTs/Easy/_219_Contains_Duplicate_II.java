package leeTs.Easy;
import java.util.HashSet;

public class _219_Contains_Duplicate_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean contansNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> record = new HashSet<>();
		for(int i = 0; i < nums.length; i ++) {
			if(i > k)
				record.remove(nums[i - k - 1]); // keep an sliding windows of the array
			if(!record.add(nums[i]))// this means there is a duplicated number in the window
				return true;
		}
		return false;
	}
	
}
