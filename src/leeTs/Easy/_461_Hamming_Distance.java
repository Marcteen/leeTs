package leeTs.Easy;

public class _461_Hamming_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hammingDistance(int x, int y) {
        int intersection = x ^ y;
        int count = 0;
        while(intersection > 0) {// can also use Integer.bitCount()
            count ++;
            intersection &= (intersection - 1);
        }
        return count;
    }

}
