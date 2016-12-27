package leeTs.Easy;

public class _278_First_Bad_Version {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBadVersion(int version) {
		return true;
	}
	
	public int firstBadVersion(int n) {
		int head = 1;
		int tail = n;
		int mid = 0;
		while(tail > head) {
			// addition is prone to overflow, use the relative span is much better!!
			mid = head + (tail - head) / 2;
			if(isBadVersion(mid)) {
				tail = mid;
			}
			else {
				head = mid + 1;
			}
				
		}
		return head;
	}

}
