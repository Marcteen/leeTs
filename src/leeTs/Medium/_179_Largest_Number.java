package leeTs.Medium;

import java.util.Comparator;
import java.util.Arrays;

public class _179_Largest_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("21".compareTo("12"));
	}

	public String largestNumber(int[] nums) {
        if(null == nums || 0 == nums.length)
            return "0";
        Integer[] numsBoxed = new Integer[nums.length];
        for(int i = 0; i < nums.length; i ++)
        	numsBoxed[i] = nums[i];
        Arrays.sort(numsBoxed, new CombineComparator());
        StringBuilder builder = new StringBuilder();
        for(int ni : numsBoxed)
            builder.append(String.valueOf(ni));
        return builder.toString();
    }
    
    public static class CombineComparator implements Comparator<Integer> {
        public int compare(Integer foo, Integer bar) {
            String front = String.valueOf(foo);
            String behind = String.valueOf(bar);
            return (front + behind).compareTo(behind + front);
        }
    }
}
