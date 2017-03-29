package leeTs.Medium;

import java.util.Arrays;

public class _274_H_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*use the bucket to sort in one traverse and a reverse accumulation is use
	 * to get the final result*/
	public int hIndexBucketSort(int[] citations) {
        if(null == citations || 0 == citations.length)
            return 0;
        /*catch the values from 0 to n, the number greater than n
        are put into the last bucket*/
        int[] bucket = new int[citations.length + 1];
        int reverseAccum = 0;
        for(int ni : citations) {
            if(ni > citations.length)
                bucket[citations.length] ++;
            else
                bucket[ni] ++;
        }
        int i = citations.length;
        for(; i >= 0;  i--) {
            reverseAccum += bucket[i];
            if(reverseAccum >= i)
                break;
        }
        return i;
    }
	/*sort it first, then the index and the value is sufficient to do
	 * the job*/
	public int hIndex(int[] citations) {
        if(null == citations || 0 == citations.length)
            return 0;
        Arrays.sort(citations);
        int i = 0;
        for(; i < citations.length; i ++) {
            if(citations[i] >= citations.length - i)
                break;
        }
        return citations.length - i;
    }
}
