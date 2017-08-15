package leeTs.Hard;

public class _330_Patching_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{1, 3};
		System.out.println(minPatches(input, 6));
	}
	
	public static int minPatches(int[] nums, int n) {
		// use a miss means we have 1 to miss - 1 sums
        long miss = 1;// It actually means we have 0
        int countAdd = 0;
        for(int i = 0; n >= miss && i < nums.length;) {
            /*If we have 1 to miss - 1, we can have
            1 to 2 * miss - 1 after add miss, the
            next "miss" is 2 * miss*/
            if(nums[i] > miss) {
                miss += miss;
                countAdd ++;
            } else {
                miss += nums[i ++];
            }
        }
        /*Remember we need to have n < miss,
        if n = miss, it is still not covered*/
        while(miss <= n) {
            miss += miss;
            countAdd ++;
        }
        return countAdd;
    }

}
