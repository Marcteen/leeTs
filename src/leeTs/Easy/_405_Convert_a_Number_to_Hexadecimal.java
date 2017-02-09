package leeTs.Easy;


public class _405_Convert_a_Number_to_Hexadecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// the two's complement of minus number will stay the same
	// no extra process required here
	public String toHex(int num) {
		StringBuilder result = new StringBuilder();
		int remainder = 0;
		if(num < 0) {
			num += Math.pow(2, 31);
			num += 1;
		}// the 2's complement
		while(num > 0) {
			remainder = num % 16;
			num /= 16;
			if(remainder >= 10)
				result.insert(0, (char)('a' + remainder - 10));
			else
				result.insert(0, remainder);
		}
		return result.toString();
	}
}
