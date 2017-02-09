package leeTs.Easy;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class _448_Find_All_Numbers_Disappeared_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {//use a array of n to track the count is much more faster!
		LinkedList<Integer> result = new LinkedList<>();
        for(int i : nums)
            if(nums[Math.abs(i) - 1] > 0)
                nums[Math.abs(i) - 1] *= -1;
        for(int i = 0; i < nums.length; i ++)
            if(nums[i] > 0)
                result.add(i + 1);
        return result;
	}
}
