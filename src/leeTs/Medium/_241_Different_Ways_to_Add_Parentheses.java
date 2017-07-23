package leeTs.Medium;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class _241_Different_Ways_to_Add_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> diffWaysToCompute(String input) {
        HashMap<String, List<Integer>> dp = new HashMap<>();
        return getComputeWay(input, dp);
    }
    
    public List<Integer> getComputeWay(String input, HashMap<String, List<Integer>> dp) {
        List<Integer> result = new LinkedList<>();
        if(null == input)
            return result;
        String left = null, right = null;
        List<Integer> leftResult = null, rightResult = null;
        for(int i = 0; i < input.length(); i ++) {
            if(!Character.isDigit(input.charAt(i))) {
                left = input.substring(0, i);
                right = input.substring(i + 1, input.length());
                /* use different splitting point to cover all case, and use a 
                dp map to reuse the previous result just like in fibonacci array*/
                if(dp.containsKey(left))
                    leftResult = dp.get(left);
                else {
                    leftResult = getComputeWay(left, dp);
                    dp.put(left, leftResult);
                }
                if(dp.containsKey(right))
                    rightResult = dp.get(right);
                else {
                    rightResult = getComputeWay(right, dp);
                    dp.put(right, rightResult);
                }
                for(int li : leftResult)
                    for(int ri : rightResult) {
                        switch(input.charAt(i)) {
                            case '+':
                                result.add(li + ri);
                                break;
                            case '-':
                                result.add(li - ri);
                                break;
                            case '*':
                                result.add(li * ri);
                                break;
                            default:
                                result.add(3838438);
                        }
                    }
            }
        }
        /*this means the input contains only one number*/
        if(0 == result.size())
            result.add(Integer.parseInt(input));
        return result;
    }
}
