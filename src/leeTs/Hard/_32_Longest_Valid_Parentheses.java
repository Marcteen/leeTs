package leeTs.Hard;
import java.util.LinkedList;

public class _32_Longest_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*dp solution(tc for the last pure '(' string); we can also use a stack tracing index in string, if
	 * the next char is compatible with the top element in stack, they will
	 * be diminished as pair, otherwise kept in stack, finally the span in
	 * the remaining stack give the result, and it will be empty if the whole
	 * string is the solution*/
	public int longestValidParenthesesStack(String s) {
		int max = 0;
		if(null == s || 0 == s.length())
			return max;
		int left = -1, len = 0;//indicate current left bound of the valid sub string
		char c = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		for(int i = 0; i < s.length(); i ++) {
			c = s.charAt(i);
			if(c == '(')
				stack.push(i);
			else if(c == ')') {
				/*in this case, the latter valid substring cannot
				 *connect with the former one, so update the left
				 *bound to current index*/
				if(stack.size() == 0)
					left = i;
				else {
					stack.pop();
					/*this means we just found a valid sub string*/
					if(stack.size() == 0) {
						len = i - left;
					}
					/*there may be some redundent ( in the front, so we
					can get a current len after the pop()*/
					else {
					    len = i - stack.peek();
					}
					max = len > max ? len : max;
				}
			}
		}
		return max;
	}
	
	public int longestValidParentheses(String s) {
        int longest[] = new int[s.length()], longestGlobal = 0;
        char c = 0;
        if(null == s || 0 == s.length())
            return longestGlobal;
        for(int i = 1; i < s.length(); i ++) {
            c = s.charAt(i);
            /*if(c == '(')
                longest[i] = 0;
            else */if(c == ')') {
                if((i - longest[i - 1] - 1) >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
                    longest[i] = longest[i - 1] + 2;
                    /*the substring right before it may be a solution
                     * as well, so merge with it, and all the valid substring
                     * pair will be hooked in this way*/
                    if((i - longest[i - 1] - 2) >= 0)
                        longest[i] += longest[i - longest[i - 1] - 2];
                    if(longest[i] > longestGlobal)
                        longestGlobal = longest[i];
                }
                else
                    longest[i] = 0;
            }
        }
        return longestGlobal;
    }
}
