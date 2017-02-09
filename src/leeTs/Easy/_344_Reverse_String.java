package leeTs.Easy;

public class _344_Reverse_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "hello";
		String output = reverseString(input);
	}

	public static String reverseString(String s) {
		char temp = 0;
		char[] result = s.toCharArray();
		for(int head = 0, tail = s.length() - 1; head < tail; head ++, tail --) {
			if(result[head]!= result[tail]) {
				temp = result[head];
				result[head] = result[tail];
				result[tail] = temp;
			}
		}
		return String.valueOf(result);// don't use toString() for it gives the object info
	}
	
}
