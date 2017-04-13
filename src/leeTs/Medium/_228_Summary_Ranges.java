package leeTs.Medium;

import java.util.List;
import java.util.LinkedList;

public class _228_Summary_Ranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder range = new StringBuilder();
	}
	/*make it neat with loop only using the next-peeking*/
	public List<String> summaryRangesNeat(int[] nums) {
        LinkedList<String> result = new LinkedList<>();
        if(null == nums || 0 == nums.length)
            return result;
        int head = 0;
        for(int i = 0; i < nums.length; i ++) {
            head = nums[i];
            /*handle it all in one loop with peeking the next*/
            while(i + 1 < nums.length && nums[i + 1] - nums[i] == 1)
                i ++;
            /*here we already find a span, from head to nums[i]*/
            if(nums[i] == head)
                result.add(head + "");
            else
                result.add(head + "->" + nums[i]);
        }
        return result;
    }
	
	public List<String> summaryRanges(int[] nums) {
        LinkedList<String> result = new LinkedList<>();
        if(null == nums || 0 == nums.length)
            return result;
        long head = nums[0], pace = head;
        for(int i = 1; i < nums.length; i ++) {
            pace ++;
            if(pace != nums[i]) {
                if(nums[i - 1] != head)
                    result.add(head + "->" + nums[i - 1]);
                else
                	result.add(head + "");
                head = nums[i];
                pace = head;
            }
        }
        if(nums[nums.length - 1] != head)
            result.add(head + "->" + nums[nums.length - 1]);
        else
        	result.add(head + "");
        return result;
    }
}
