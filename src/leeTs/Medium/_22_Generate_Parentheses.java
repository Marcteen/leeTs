package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;

public class _22_Generate_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dividend = 0;
		int divisor = 0;
		System.out.println(dividend / divisor);
	}
	
	public List<String> generateParenthesisDPIterative(int n) {// can be solved as a dynamic programming
        List<List<String>> heap = new ArrayList<>(n + 1);// set the initial capacity doesn't means it has corresponding number of elements
        if(0 == n)
            return new ArrayList<String>();
        heap.add(new ArrayList<String>());
        heap.get(0).add("");
        List<String> inner = null;
        List<String> outter = null;
        List<String> curTarget = null;
        String relativeFront = null;
        for(int i = 1; i <= n; i ++) {
            curTarget = new ArrayList<String>(); // be careful not to put it in wrong loop layer!
            heap.add(curTarget);
            for(int j = 0; j < i; j ++) { // indicate the bracket inside the new bracket
                inner = heap.get(j);
                outter = heap.get(i - j - 1);
                for(String in : inner) {
                    relativeFront = "(" + in + ")";
                    for(String out : outter)
                        curTarget.add(relativeFront + out);// One way is sufficient, because there already exists same pair of brackets at the tail in previous patters
                }
            }
        }
        return heap.get(n);
    }

    
    public List<String> generateParenthesisRecursive(int n) {// can be solved as a dynamic programming
        List<String> result = new ArrayList<>();
        combination(n, 0, 0, "", result);
        return result;
    }
    
    public void combination(int n, int step, int left, String prefix, List<String> result) {
        if(step == 2 * n - 1) {
            result.add(prefix + ")");
        }
        else{
            if(left < n)// be careful the realtion between condition and counter!
                combination(n, step + 1, left + 1, prefix + "(", result);
            if(step - left < left)
                combination(n, step + 1, left, prefix + ")", result);
        }
    }
}
