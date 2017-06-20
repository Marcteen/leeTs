package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;

public class _229_Majority_Element_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> majorityElement(int[] nums) {
        /*There are at most two major element which take more than one-third*/
        List<Integer> result = new ArrayList<>(2);
        if(null == nums || 0 == nums.length)
            return result;
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0;
        for(int ni : nums) {
            if(ni == major1)
                count1 ++;
            else if(ni == major2)
                count2 ++;
            else if(count1 == 0) {
                major1 = ni;
                count1 ++;
            } else if(count2 == 0) {
                major2 = ni;
                count2 ++;
            } else {
            /*the major number must have the most element, so it
            is ok to reduce them two.(Here the rest is less than one third)*/
                count1 --;
                count2 --;
            }
        }
        /*they are only the candidates, because if one is about one twice, they wil be
        only one sufficient element*/
        count1 = 0;
        count2 = 0;
        for(int ni : nums) {
            if(ni == major1)
                count1 ++;
            else if(ni == major2)
                count2 ++;
        }
        if(count1 > nums.length / 3)
            result.add(major1);
        if(count2 > nums.length / 3)
            result.add(major2);
        return result;
    }
}
