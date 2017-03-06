package leeTs.Medium;

public class _137_Single_Number_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*Statement of our problem: "Given an array of integers, every element
    appears k (k > 1) times except for one, which appears p times
    (p >= 1, p % k != 0). Find that single one."*/
    public int singleNumber(int[] nums) {
        /*because we have k = 3, so each bit need two bit to count, bit2 provide
        the higher bit in bit count*/ 
        int bit2 = 0, bit1 = 0, mask = 0;
        for(int ni : nums) {
            /* when bit1 and ni both provide 1, bit2 got a bypass, otherwise it won't
            change*/
            bit2 ^= bit1 & ni;
            // the exlusive or is doing adding without bypass
            bit1 ^= ni;
            /*when reach k, we should cut it to zero, here k == 3, so find the bit
            which provide in bit2 and bit1(0x3), then use xor to make them zero,
            for other k, we can use ~, & to construct the mask bits, such as 10,
            the mask is bit2 & ~bit1*/
            mask = bit1 & bit2;
            bit2 ^= mask;
            bit1 ^= mask;
        }
        // 0x1 indicate the number than appears only once
        return bit1;
    }
}
