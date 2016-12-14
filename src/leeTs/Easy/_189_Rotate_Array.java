package leeTs.Easy;

public class _189_Rotate_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void rotate1(int[] nums, int k) {
        int indeedK = k % nums.length;
        int[] swap = new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
        	swap[i] = nums[i];
        }
        
        for(int i = 0; i < nums.length; i ++) {
        	nums[(i + indeedK) % nums.length] = swap[i];
        }
    }
	
	public void rotate2(int[] nums, int k) {// too slow
		int tail = 0;
		k %= nums.length;
		for(int i = 0; i < k; i ++) {
			tail = nums[nums.length - 1];
			for(int j = nums.length - 2; j >= 0; j --)
				nums[j + 1] = nums[j];
			nums[0] = tail;
		}
	}

	public void rotate3(int[] nums, int k) {// linked transferring?
		k %= nums.length;
		if(0 == k)
			return;
		else {
			int swappedVal = 0;
			int swapIndex = 0;
			int head = 0;// the start index of every turn
			int period = 0;// if we need restart, it will give how many turns we need to run
			int periodStep = 0;// how mang step in a turn we need to move
			
			int maxDivisor = getMaxDivisor(nums.length, k); // the transfer step's key
			period = maxDivisor;// the number of turns, >1 means we need restart transferring
			periodStep = nums.length / maxDivisor;// the number of steps in each turn
			
			for(; period > 0; period --) {
				swappedVal = nums[swapIndex];
				for(int i = 0; i < periodStep; i ++) {
					swapIndex  += k;
					swapIndex %= nums.length;
					swappedVal ^= nums[swapIndex];
					nums[swapIndex] ^= swappedVal;
					swappedVal ^= nums[swapIndex];
				}
				swapIndex = ++ head;
			}
		}
	}
	
	public static int getMaxDivisor(int a,int b){
		  int x = a;
		  int y = b;
		  while(Math.min(x, y) != 0){
		   int temp = y;
		   y= Math.min(x, y);
		   x= Math.max(temp, x) % Math.min(temp, x);
		   if(Math.min(x, y) == 0) {
			   return Math.max(x,y);
		   }
		  }
		  return 0 == Math.max(a,b) ? 1 : Math.max(a,b);
	}
	
	public void rotate4(int[] nums, int k) { // handle it through reversing
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        reverse(nums,0,nums.length - 1); // reverse all as a mirror
        reverse(nums,0,step - 1);// start to length of step
        reverse(nums,step,nums.length - 1);// step to tail except the last one
    }
    
    //reverse int array from n to m
    public void reverse(int[] nums, int n, int m){
        while(n < m){
            nums[n] ^= nums[m];
            nums[m] ^= nums[n];
            nums[n] ^= nums[m];
            n++;
            m--;
        }
    }
}
