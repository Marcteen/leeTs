package leeTs.Easy;

public class _263_Ugly_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isUgly(int num) {// Find the prime factor, not prime numbers
		if(0 == num)
			return false;
		while(0 == num % 2)
			num /= 2;
		while(0 == num % 3)
			num /= 3;
		while(0 == num % 5)
			num /= 5;
		return num == 1;
	}
	
}
