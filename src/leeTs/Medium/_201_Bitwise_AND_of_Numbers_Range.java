package leeTs.Medium;

public class _201_Bitwise_AND_of_Numbers_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(1, 100));
	}
	/* Just check the higher bit of m and n, the same
	 * bit will remain the same in the range, and once
	 * found a vary bit, the unchanged high bit sequence
	 * ends*/
	/*also we can move m and n toward right util
	 * they equal, we need to keep track of shift step number
	 * for get the real and-result by shifting toward left!!*/
	public static int rangeBitwiseAnd(int m, int n) {
        long bitPivot = 1;// for the max vale of int
        // find the hight 1 bit of n
        while((bitPivot << 1) <= n)
            bitPivot <<= 1;
        int result = 0;
        while(bitPivot > 0 && (bitPivot & n) == (bitPivot & m)) {
            result |= (bitPivot & n);
            bitPivot >>= 1;
        }
        return result;
    }

}
