package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _90_Subset_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int pre = 0, tail = 0;
        List<Integer> cur = null;
        for(int i = 0; i < nums.length; i ++) {
            if(i == 0 || nums[i] != nums[i - 1])// not a dulplicate one
                pre = 0;
            tail = result.size();// otherwise the duplicate one can only be insert into the subset contains the former element
            for(; pre < tail; pre ++) {
                cur = new ArrayList<>(result.get(pre));
                cur.add(nums[i]);
                result.add(cur);
            }
        }
        return result;
    }

}
