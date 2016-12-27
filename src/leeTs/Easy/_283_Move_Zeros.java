package leeTs.Easy;

public class _283_Move_Zeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void moveZeros(int[] nums) {
		int state = 0;// 0-just scan, 1-already found a zero
		int numsAllZeroes = 0;
		for(int i = 0; i < nums.length; i ++) {
			switch(state) {
			case 0:// nothing special
				if(0 == nums[i]){
					state = 1;
					numsAllZeroes ++;
				}
				break;
			case 1:
				if(0 == nums[i]) {
					numsAllZeroes ++;
				}
				else
					nums[i - numsAllZeroes] = nums[i];
			}
		}
		for(int i = nums.length - numsAllZeroes; i < nums.length; i ++)
			nums[i] = 0;
	}

	public void moveZeroesNeat(int[] nums) {
		if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
}
