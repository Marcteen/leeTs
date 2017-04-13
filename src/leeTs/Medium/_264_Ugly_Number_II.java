package leeTs.Medium;

public class _264_Ugly_Number_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(3));
	}

	/*Use three pointer to track the less next number, which
	 * can generate the sequence in order. Each step we need to
	 * update them to the very next available*/
	public static int nthUglyNumber(int n) {
        if(n < 1)
            return 0;
        int index = 0, two = 0, three = 0, five = 0;
        int[] uglyNumber = new int[n];
        uglyNumber[index ++] = 1;
        for(; index < n; index ++) {
            uglyNumber[index] = Math.min(Math.min(uglyNumber[two] * 2, uglyNumber[three] * 3), uglyNumber[five] * 5);
            /*Must contain the equality because it may just bee added,
             * and the while is used to guarantee the "greater", which make
             * it the suitable new element later*/
            while(uglyNumber[two] * 2 <= uglyNumber[index])
                two ++;
            while(uglyNumber[three] * 3 <= uglyNumber[index])
                three ++;
            while(uglyNumber[five] * 5 <= uglyNumber[index])
                five ++;
        }
        return uglyNumber[n - 1];
    }
}
