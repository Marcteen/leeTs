package leeTs.Easy;

public class _202_Happy_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isHappy(int n) {
		int sum = 0;
		int a = 0;
		int ta = 0;
		int b = 0;
		while(n != 1) {
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
			n = sum;
		}
		return true;
	}
}
