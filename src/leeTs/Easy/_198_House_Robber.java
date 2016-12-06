package leeTs.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class _198_House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ListNode{
		int val;
		int index;
		ListNode(int x, int y) {
			val = x;
			index = 0;
		}
	}
	class ListNodeComparator implements Comparator {
		public int compare(Object arg0, Object arg1) {
			ListNode foo = (ListNode) arg0;
			ListNode bar = (ListNode) arg1;
			if(foo.val > bar.val)
				return 1;
			else
				if(foo.val < bar.val)
					return -1;
				else
					return 0;
		}
	}
	
	boolean checkAvaliable(int index, int[] nums) {
		if(index > 0)
			if(-1 == nums[index - 1])
				return false;
		if(index < nums.length - 1)
			if(-1 == nums[index + 1])
				return false;
		return true;
	}

	public int robRubbish(int[] nums) {
		int result = 0;
		ListNode[] indexedList = new ListNode[nums.length];
		for(int i = 0; i < nums.length; i ++)
		    indexedList[i] = new ListNode(nums[i], i);
		Arrays.sort(indexedList, new ListNodeComparator());
		for(int i = 0; i < nums.length; i++) {
			if(checkAvaliable(indexedList[i].index, nums)) {
				result += nums[indexedList[i].index];
				nums[indexedList[i].index] = -1;
			}
		}
		return result;
	}
	
	public int rob(int[] nums) {
		int result1 = 0;
		int result2 = 0;
		for(int i = 0; i < nums.length; i += 2)
			result1 += nums[i];
		for(int i = 1; i < nums.length; i += 2)
			result2 += nums[i];
		return result1 > result2 ? result1 : result2;
	}
	
}
