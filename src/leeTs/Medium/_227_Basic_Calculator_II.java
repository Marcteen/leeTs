package leeTs.Medium;

import java.util.LinkedList;

public class _227_Basic_Calculator_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = " 3/2 ";
		System.out.println(calculate(input));
	}
	
	public static int calculate(String s) {
        if(null == s || 0 == s.length())
            return 0;
        int number = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        /*we handle current operator util we meet next*/
        char sign = '+';
        for(int i = 0; i < s.length(); i ++) {
            for(; i < s.length() && Character.isDigit(s.charAt(i)); i ++) {
                number = number * 10 + s.charAt(i) - '0';
            }
            /* the number may be terminated by operator or the end of s,
            we should skip the blank space*/
            if(i == s.length() || s.charAt(i) != ' ') {
                if(sign == '+') {
                    stack.push(number);
                } else if(sign == '-') {
                    stack.push(number * -1);
                } else if(sign == '*') {
                    stack.push(stack.pop() * number);
                } else if(sign == '/') {
                    stack.push(stack.pop() / number);
                }
                if(i < s.length())
                    sign = s.charAt(i);
                number = 0;
            }
        }
        for(int n : stack)
            number += n;
        return number;
    }
}
