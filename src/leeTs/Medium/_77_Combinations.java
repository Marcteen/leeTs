package leeTs.Medium;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class _77_Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(0 == n || 0 == k)
            return result;
        LinkedList<Integer> stack = new LinkedList<>();
        int cur = 0, size = 0;
        stack.push(0);
        while(!stack.isEmpty()) {
            cur = stack.pop();
            size = stack.size();
            while(n - cur >= k - size && size < k) {
                stack.push(++ cur);
                size ++;
            }
            if(size == k)
                result.add((LinkedList<Integer>)stack.clone());
        }
        
        return result;
    }
}
