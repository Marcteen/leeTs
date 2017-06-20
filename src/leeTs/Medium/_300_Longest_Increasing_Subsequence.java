package leeTs.Medium;

public class _300_Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*tricky dp using adding the tail element one by one*/
	public int lengthOfLISDp(int[] nums) {
		if(null == nums || 0 == nums.length) {
            return 0;
        }
		int[] tails = new int[nums.length];
		/* size means the number, tails[i] stores the least number of
		 * the sub sequence of length i + 1*/
		int low = 0, mid = 0, high = 0, size = 0;
		for(int ni : nums) {
			low = 0;
			high = size;
			while(low < high) {
				mid = low + (high - low) / 2;
				/*we need to find the first element that is
				 * not less than ni(for the tail update, ni
				 * is surely less than tail[low], otherwise
				 * the loop will increase i, in this way 
				 * we give the room to obtain longer solution)
				 * or reach beyond the current longest sub
				 * sequence, noted that the tail[size] is not obtained yet,
				 * because current solution of size is coressponding to tails[size - 1]*/
				if(tails[mid] < ni)
					low = mid + 1;
				// it may just at target, so move to it rather than skip it
				else
					high = mid;
			}
			/*now low(== high) must at the insert position, we can figure out
			 * that tails must be ascend because the loop will skip the values
			 * that less than ni*/
			tails[low] = ni;
			/*already get a new one, so expend it*/
			if(low == size)
				size ++;
		}
		return size;
	}
	
	/*Naive prefix checking one by one*/
	public int lengthOfLIS(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return 0;
        }
        int[] length = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i ++) {
            for(int j = 0; j < i; j ++) {
                if(nums[i] > nums[j] && length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    if(length[i] > max)
                        max = length[i];
                }
            }
        }
        /*the values in length just one less than the real ones*/
        return max + 1;
    }
}
