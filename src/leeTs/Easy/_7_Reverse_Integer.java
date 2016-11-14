package leeTs.Easy;

public class _7_Reverse_Integer {

	public static void main(String[] args) {
		int input = 1000000003;
		int result = reverse(input);
		System.out.println(String.format("The output is %d", result));

	}
	public static int reverse(int x) {
		int symbol = 1;
		if(x < 0)
			symbol = -1;
		else
			if(0 == x)
				return x;
		int xAbs = Math.abs(x);
		long result = 0;
		for(;xAbs > 0;xAbs /= 10) {
			result *= 10;
			result += xAbs % 10;
		}
		result *= symbol;
		if(result > Integer.MAX_VALUE)
			return 0;
		else
			if(result < Integer.MIN_VALUE)
				return 0;
			else
				return (int)result;
    }
	
}
