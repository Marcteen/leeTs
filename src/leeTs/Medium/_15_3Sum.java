package leeTs.Medium;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class _15_3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = threeSum(new int[]{1, -1, -1, 0});
		System.out.println("hehe");
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int start = 0, end = 0;
		ArrayList<List<Integer>> result = new ArrayList<>();
		int available = nums.length - 3;
		int minus = 0;
		int positive = 0;
		for(int i = 0; i <= available;) {
			minus = - nums[i];
			start = i + 1;
			end = nums.length - 1;
			while(start < end) {
			    positive = nums[start] + nums[end];// once forget its reusing in line38, removed it incorrectly
				if(positive == minus) {
					ArrayList<Integer> triplet = new ArrayList<>();
					triplet.add(nums[i]);
					triplet.add(nums[start]);
					triplet.add(nums[end]);
					result.add(triplet);
					while(end > 0 && nums[-- end] == nums[end + 1]);
					while(start < nums.length - 1 && nums[++ start] == nums[start - 1]);
				}
				else
					if(positive > minus)// move end to left
						while(end > 0 && nums[-- end] == nums[end + 1]);
					else
						while(start < nums.length - 1 && nums[++ start] == nums[start - 1]);
			}
			while(nums[++ i] == nums[i - 1] && i <= available);// be careful about the order of prefix self-adding operator and range check
		}
		return result;
	}

	public static List<List<Integer>> threeSumNaive(int[] nums) {// way too slow
        HashSet<List<Integer>> result = new HashSet<>();
        Integer[] selected = new Integer[3];
        int sum = 0;
        getCombination(nums, 0, 3, selected, 0, result);
        return new ArrayList<List<Integer>>(result);
    }
    
    public static void getCombination(int[] nums, int start, int count, Integer[] selected, int sum, HashSet<List<Integer>> result){
        if(0 == count) {
            if(0 == sum) {
            	Integer[] copy = Arrays.copyOf(selected, 3);// copy it because we need to reuse the prefix element, sort it directly will mess up.
                Arrays.sort(copy);
                result.add(Arrays.asList(copy));
            }
        }
        else {
            for(int i = start; i < nums.length; i ++) {
                selected[3 - count] = nums[i];
                getCombination(nums, i + 1, count - 1, selected, sum + nums[i], result);
            }
        }
    }
	
}
