package leeTs.Easy;

public class _441_Arranging_Coins {

	public void main(String[] args) {
		
	}
	
	public int arrangeCoinsNavie(int n) {
		int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
	}
	
	public int arrageCoinsBinarySearch(int n) {
		int head = 0;
		int tail = (int)(Math.sqrt(n) * Math.sqrt(2))  + 1;//sqrt(2 * n) is prone to overflow!!! Be careful to any number increasing!
		int mid = 0;
		while(head <= tail) {
			mid = head + (tail - head) / 2;// don't write as head + tail / 2
			if(0.5 * mid * mid + 0.5 *mid <= n)// be careful about the equation.
				head = mid + 1;
			else
				tail = mid - 1;
		}
		return head - 1;
	}
}
