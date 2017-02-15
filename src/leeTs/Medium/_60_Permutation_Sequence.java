package leeTs.Medium;

import java.util.List;
import java.util.LinkedList;

public class _60_Permutation_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String getPermutationTrick(int n, int k) {
        List<Integer> candidates = new LinkedList<>();
        int base = 1, target = 0;
        StringBuilder collect = new StringBuilder();
        for(int i = 1; i <= n; i ++) { // remove the selected and keep in order, that's a linked list
            candidates.add(i);
            base *= i;
        }
        base /= n;/* use (n - 1)! is essentially important!!!! use n confuses a lot!!! for n, each group is
        made of (n - 1)! elements, so it should be divisor, rather than n!!!!!!!!!*/
        //trick: index correct!!!!!(counting in real computer pattern), or the last will be incorrect
        k --;// should be start at 0, all the way up to n - 1
        while(n > 0) {
            target = k / base;
            k %= base;
            n --;
            if(n > 0)
                base /= n;
            collect.append(candidates.get(target));
            candidates.remove(target);
        }
        return collect.toString();
    }
	
	public String getPermutationNaive(int n, int k) {
        int[] permutation = new int[n];
        int minPos = 0, i = 0;
        for(i = 1; i <= n; i ++)
            permutation[i - 1] = i;
        for(; k > 1; k --) {
            for(i = n - 1; i > 0 && permutation[i] < permutation[i - 1]; i --);
            for(minPos = i; minPos < n && permutation[minPos] > permutation[i - 1]; minPos ++);
            swap(permutation, i - 1, minPos - 1);
            inverse(permutation, i, n - 1);
        }
        StringBuilder collect = new StringBuilder(n);
        for(int pi : permutation)
            collect.append(pi);
        return collect.toString();
    }
    
    public void inverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start ++, end --);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}
