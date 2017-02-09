package leeTs.Easy;

public class _326_Power_of_Four {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfFour(int num) {
		if(num < 0)
			return false;
		else
			if((num & (num - 1)) == 0) {
				if((num & 0x55555555) == 0)
					return false;
				else
					return true;
			}
			else
				return false;
	}
	
}
