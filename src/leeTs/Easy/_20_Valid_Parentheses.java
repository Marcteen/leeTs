package leeTs.Easy;

import java.util.Stack;

public class _20_Valid_Parentheses {

	public static void main(String[] args) {
		String input = "()()(){}{}[][())";
		boolean result = isValid(input);
		if(result)
			System.out.print("True");
		else
			System.out.print("Fasle");
	}
	
	public static boolean isValid(String s) {
		Stack<Character> record = new Stack<>();
		for(int i = 0;i < s.length(); i++) {
			if('(' == s.charAt(i) || '[' == s.charAt(i) || '{' == s.charAt(i))
				record.push(s.charAt(i));
			else
				if(!record.isEmpty()) {
					switch(record.pop()) {
					case '(':
						if(')' != s.charAt(i))
							return false;
						break;
					case '[':
						if(']' != s.charAt(i))
							return false;
						break;
					case '{':
						if('}' != s.charAt(i))
							return false;
					}
				}
				else
					return false;
		}
		if(record.isEmpty())
			return true;
		else
			return false;
	}

}
