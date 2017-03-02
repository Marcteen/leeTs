package leeTs.Medium;

import java.util.LinkedList;

public class _150_Evaluate_Reverse_Polish_Notation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = "1231".toCharArray();
		chars[0] ^= chars[1];
        chars[1] ^= chars[0];
        chars[0] ^= chars[1];

        System.out.println(String.valueOf(chars));
	}
	public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        int former = 0;
        for(String str : tokens) {
            switch(str) {
                case "+":
                    former = stack.pop();
                    stack.push(stack.pop() + former);
                    break;
                case "-":
                    former = stack.pop();
                    stack.push(stack.pop() - former);
                    break;
                case "*":
                    former = stack.pop();
                    stack.push(stack.pop() * former);
                    break;
                case "/":
                    former = stack.pop();
                    stack.push(stack.pop() / former);;
                    break;
                default:
                    stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
