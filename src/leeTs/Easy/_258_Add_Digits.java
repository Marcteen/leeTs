package leeTs.Easy;

public class _258_Add_Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int addDigitsTricky(int num) {// check here https://en.wikipedia.org/wiki/Digital_root
		return 1 + (num - 1) % 9;// actually it slower than the naive method on leetcode
	}
	
	public int addDigits(int num) {
		int n = 0;
		while(num >= 10) {
			while(num > 0) {
				n += num % 10;
				num /= 10;
			}
			num = n;
			n = 0;
		}
		return num;
	}

}
