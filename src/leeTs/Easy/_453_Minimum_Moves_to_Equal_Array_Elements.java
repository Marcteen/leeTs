package leeTs.Easy;

public class _453_Minimum_Moves_to_Equal_Array_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/*We can see it as adding bricks to heaps, each time add n - 1 bricks to 
	 * n - 1 heaps correspondingly. Say we need k times to get all heap equals
	 * to each other, noted that the heap with minimum number(say it is min) of 
	 * bricks will get new brick each time, and let the number of bricks in all
	 * heap at beginning be s, so finally we will add (n - 1) * k bricks in total,
	 * and each head has min + k bricks, so (n - 1) * k + k = (min + k) * n, we
	 * can use it to get the answer*/
	public int minMoves(int[] nums) {
		int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num < min)
                min = num;
            sum += num;
        }
        return sum - min * nums.length;
	}
	
}
