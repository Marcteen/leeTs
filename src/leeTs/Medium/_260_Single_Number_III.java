package leeTs.Medium;

public class _260_Single_Number_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] singleNumber(int[] nums) {
        int accum1 = 0, accum2 = 0, flag = 1;
        for(int ni : nums)
            accum1 ^= ni;
        while((flag & accum1) == 0)
            flag <<= 1;
        //don't forget to reset it!
        accum1 = 0;
        for(int ni : nums) {
            if((flag & ni) == 0)
                accum1 ^= ni;
            else
                accum2 ^= ni;
        }
        return new int[]{accum1, accum2};
    }
}
