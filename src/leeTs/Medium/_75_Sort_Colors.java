package leeTs.Medium;

public class _75_Sort_Colors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		print(a ++);
	}

	static public void print(int a) {
		System.out.println(a);
	}
	// Neat but no obviously performance improvement
	public void sortColorsNeatPartition(int[] nums) {
        if(null == nums || nums.length < 2)
            return;
        int zero = 0, second = nums.length - 1;
        for(int i = 0; i <= second; i ++) {/*It handle nums[0] for potential 2, make it position available and correct*/
            while(2 == nums[i] && second > i)/*nums[second] may be two, too. This loop ensures it swap to the farthest
            non-two element!!!*/
                swap(nums, i, second --);
            while(0 == nums[i] && zero < i)
                swap(nums, i , zero ++);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
	public void sortColorsNaivePartition(int[] nums) {
        if(null == nums || nums.length < 2)
            return;
        int low = 0, high = nums.length - 1, mid = 0;
        for(int midValue = 2; midValue > 0 && high > low; midValue --) {
            if(nums[high] != midValue) {// take it for the first swap
                for(mid = 0; mid < high && nums[mid] != midValue; mid ++);// be careful about the lower bound !!!!!!!!!!!
                if(mid == high)// no such color, switch to next
                    continue;
                nums[mid] = nums[high];
            }
            while(low < high) {
                while(low < high && nums[low] < midValue)
                    low ++;
                if(low == high)
                    break;
                else {
                    nums[high] = nums[low];
                    high --;
                }
                while(low < high && nums[high] >= midValue)
                    high --;
                if(low == high)
                    break;
                else {
                    nums[low] = nums[high];
                    low ++;
                }
            }
            nums[low] = midValue;
            high = low - 1;
            low = 0;
        }
    }
}
