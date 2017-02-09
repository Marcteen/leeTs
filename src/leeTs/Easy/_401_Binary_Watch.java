package leeTs.Easy;
import java.util.List;
import java.util.LinkedList;

public class _401_Binary_Watch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 2;
		List<String> output = readBinaryWatch(input);
	}

	public static List<String> readBinaryWatch(int num) {
		int[] hourNums = new int[]{8, 4, 2, 1};
		int[] minuteNums = new int[]{32, 16, 8, 4, 2, 1};
		LinkedList<String> result = new LinkedList<>();
		for(int i = 0; i <= num; i ++) {
			LinkedList<Integer> hourValues = getCombination(hourNums, i);
			LinkedList<Integer> minuteValues = getCombination(minuteNums, num - i);
			for(int hour : hourValues) {
				if(hour >= 12)// the question do not want the 12 for hours !
					continue;
				else {
					for(int minute : minuteValues) {
						if(minute >= 60)// the 60 in minute doesn't make sense !
							continue;
						else
							result.add(hour + ":" + (minute >= 10 ? minute + "" : "0" + minute));
					}
				}
			}
		}
		return result;
	}
	
	public static LinkedList<Integer> getCombination(int[] nums, int numSelecteds) {
		LinkedList<Integer> result = new LinkedList<>();
		generateCombination(nums, numSelecteds, 0, result, 0);
		return result;
	} 
	
	public static void generateCombination(int[] nums, int count, int start, LinkedList<Integer> result, int sum) {
		if(0 == count) 
			result.add(sum);
		else
			for(int i = start; i <= nums.length - count; i ++) {
				generateCombination(nums, count - 1, i + 1, result, sum + nums[i]);// show start from the current head element, not current left bound "start"
			}
	}
}
