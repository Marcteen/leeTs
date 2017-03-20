package leeTs.Medium;

public class _213_House_Robber_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Since the last house is affected by the first house, we can separate
    the case by if we rub the first house, noted that if we don't rob i, we
    should taken the max as max(preTaken, preNotTaken)*/
    public int rob(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        if(1 == nums.length)
            return nums[0];
        //take the first one
        int temp = 0, preTaken = 0, preNotTaken = 0, taken = 0, notTaken = 0;
        for(int i = 2; i < nums.length - 1; i ++) {
            taken = nums[i] + preNotTaken;
            notTaken = Math.max(preNotTaken, preTaken);
            preTaken = taken;
            preNotTaken = notTaken;
        }
        int withFirst = nums[0] + Math.max(taken, notTaken);
        //discard the first one
        taken = 0;
        notTaken = 0;
        preTaken = 0;
        preNotTaken = 0;
        for(int i = 1; i < nums.length; i ++) {
            taken = nums[i] + preNotTaken;
            notTaken = Math.max(preNotTaken, preTaken);
            preTaken = taken;
            preNotTaken = notTaken;
        }
        int withoutFirst = Math.max(taken, notTaken);
        return withoutFirst > withFirst ? withoutFirst : withFirst;
    }
}
