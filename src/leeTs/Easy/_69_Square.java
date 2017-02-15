package leeTs.Easy;

public class _69_Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* use pow is prone to overflow, with division is much better!! Because the range
	 * is narrowed down from large to ideal gradually!!*/
	public int mySqrt(int x) {
        if(x <= 1)
            return x;
        int low = 1, high = x, mid = 0, factor = 0;
        while(low < high) {
            mid = low + (high - low) / 2 + 1;
            factor = x / mid; // a good way to avoid overflow doing power with x !!!!!!!!!!!
            if(factor < mid)
                high = mid - 1;
            else
                if(factor > mid)
                    low = mid;
                else
                    return mid;
        }
        mid = low + (high - low) / 2;
        return mid;
    }
}
