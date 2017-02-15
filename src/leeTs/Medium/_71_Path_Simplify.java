package leeTs.Medium;

import java.util.Collections;
import java.util.LinkedList;

public class _71_Path_Simplify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> result = new LinkedList<>();
		result.offer(1);
		result.offer(2);
		result.offer(3);
		result.offer(4);
		System.out.println("as queue: " + result);
		result.clear();
		result.push(1);
		result.push(2);
		result.push(3);
		result.push(4);
		System.out.println("as statck: " + result);
		while(!result.isEmpty())
			System.out.println(result.getLast());
	}
	/* Except push(), pop(), offer(), poll(), all other _Last and _First
	 * are in the aspect of the list itself, and remember the head of list
	 * is set to be the exit of elements for stack and queue*/
	public String simplifyPath(String path) {
        if(null == path || path.length() == 1)
            return path;
        LinkedList<String> stack = new LinkedList<>();
        int length = path.length(), i = 1;
        int upperBound = 0;
        String identifer = null;
        StringBuilder simplifiedPath = new StringBuilder();
        for(; i < length; i ++) {
            if(path.charAt(i) == '/') {
                if(i - 1 > upperBound) {
                    pathGrow(stack, path.substring(upperBound + 1, i));   
                }
                upperBound = i;
            }
        }
        if(i - 1 > upperBound)
            pathGrow(stack, path.substring(upperBound + 1, i));
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty())
            simplifiedPath.append("/" + stack.pollLast());
        return simplifiedPath.toString();
    }
    
    public void pathGrow(LinkedList<String> stack, String identifier) {
        if(identifier.equals("..")) {
            if(!stack.isEmpty())
                stack.pop();
        }
        else 
            if(!identifier.equals(".")) {
                stack.push(identifier);
            }
    }
}
