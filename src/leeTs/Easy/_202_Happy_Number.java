package leeTs.Easy;
import java.util.Set;
import java.util.HashSet;

public class _202_Happy_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4, 5, 6, 1};
		checkFirstDup(input);
	}

	public static boolean isHappy(int n) {
		int sum = n;
		Set<Integer> trace = new HashSet<>();
		while(1 != n) {
			sum = 0;
			while(0 != n) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if(!trace.add(sum))
				return false;
			n = sum;
		}
		return true;
	}
	
	public static boolean isHappy2(int n) {
		int sumBehind = n;
		int sumFront = n;
		while(1 != n) {
			sumBehind = getDigitPowSum(sumBehind);
			sumFront = getDigitPowSum(sumFront);
			sumFront = getDigitPowSum(sumFront);
			if(sumFront == sumBehind)
				return false;
			n = sumBehind;
		}
		return true;
	}
	public boolean isHappy3(int n) {
        if( n == 0 ){
            return false;
        }
        while( n != 1 && n != 4 ){
            n = getDigitPowSum(n);
        }
        return (n == 1);
    }
	public static int getDigitPowSum(int n) {
		int result = 0;
		while(0 != n) {
			result += Math.pow(result % 10, 2);
			n /= 10;
		}
		return result;
	}
//below are rubbished
	public static boolean isHappyhehe(int n) {
		int sum = 0;
		int a = 0;
		int ta = 0;
		int b = 0;
		while(1 != n) {
			sum = 0;
			while(0 != n) {
				sum *= 10;
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			ta = (~a & b & sum) | (a & ~b & ~sum);// the generous num count record method from https://discuss.leetcode.com/topic/22821/an-general-way-to-handle-all-this-sort-of-questions/2
			b = (~a & ~b & sum) | (~a & b & ~sum);
			a = ta;
			if( (a & ~b) == sum)// find the only number that occur two times, but it will not working in this situation
				return false;
			n = sum;  
		}
		return true;
	}
	
	public static void checkFirstDup(int[] nums) {
		int a = 0;
		int ta = 0;
		int b = 0;
		for(int i = 0; i < nums.length; i ++) {
			ta = (~a & b & nums[i]) | (a & ~b & ~nums[i]);// the generous num count record method from https://discuss.leetcode.com/topic/22821/an-general-way-to-handle-all-this-sort-of-questions/2
			b = (~a & ~b & nums[i]) | (~a & b & ~nums[i]);
			a = ta;
			if( (a & ~b) == nums[i]) {// find the only number that occur two times
				System.out.println("天了噜");
				System.out.println(String.format("%d to %d", (a & ~b), nums[i]));
			}
		}
	}
}
