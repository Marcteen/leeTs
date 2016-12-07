package leeTs.Easy;

public class _202_Happy_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 2;
		boolean i = isHappy(input);
	}

	public static boolean isHappy(int n) {
		long sum = 0;
		long a = 0;
		long ta = 0;
		long b = 0;
		while(1 != sum) {
			sum = 0;
			while(0 != n) {
				sum *= 10;
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			ta = (~a & b & sum) | (a & ~b & ~sum);// the generous num count record method from https://discuss.leetcode.com/topic/22821/an-general-way-to-handle-all-this-sort-of-questions/2
			b = (~a & ~b & sum) | (~a & b & ~sum);
			a = ta;
			if( (a & ~b) == sum)// find the only number that occur two times
				return false;
		}
		return true;
	}
}
