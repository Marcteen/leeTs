package leeTs.Easy;

public class _88_Merge_Sorted_Array {

	public static void main(String[] args) {

	}

	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		int[] nums2Pos = new int[n];
		int j = 0;
		for(int i = 0; i < n; i ++) { // find the insert position for nums2[i]
			while(nums1[j] < nums2[i] && j < m)
				j ++;
			nums2Pos[i] = j; // for move elements in nums1 at once		
		}
		int previous = m - 1;
		for(int i = n - 1; i >= 0; i --) {
			for(int k = previous; k >= nums2Pos[i]; k --)
				nums1[k + i + 1] = nums1[k];
			nums1[nums2Pos[i] + i] = nums2[i];
			previous = nums2Pos[i] - 1;
		}
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = n + m - 1;
		while (j >= 0 && i >= 0) {
			nums1[k --] = nums1[i] > nums2[j] ? nums1[i --] : nums2[j --];
		}
		while(j >= 0) {
			nums1[k --] = nums2[j --];
		}
	}
}
