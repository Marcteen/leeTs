package leeTs.Medium;

public class _215_Kth_Largest_Element_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1, pivot;
        // find the index of k-largest element
        k = nums.length - k;
        while(low < high) {
            //thus make the bounds inherited
            pivot = partition(nums, low, high);
            if(pivot == k)
                break;
            else if(pivot > k)
            // the target should be at its right
                high = pivot - 1;
            else if(pivot < k)
            // the target should be at its left
                low = pivot + 1;
        }
        // for now, the target must be at its position
        return nums[k];
    }
    
    public int partition(int[] nums, int low, int high) {
        /*take the first element as pivot by default, we must keep
         * a copy of pivot because it origin position will be taken!!!*/
        int pivot = nums[low];
        while(low < high) {
            while(low < high && pivot <= nums[high])
                high --;
            if(low < high)
                nums[low ++] = nums[high];
            while(low < high && nums[low] < pivot)
                low ++;
            if(low < high)
                nums[high --] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
    
    public void swap(int[] nums, int foo, int bar) {
        nums[foo] ^= nums[bar];
        nums[bar] ^= nums[foo];
        nums[foo] ^= nums[bar];
    }
}
