package leeTs.Easy;

public class _28_Implement_strStr {

	public static void main(String[] args) {
		String haystack = "askaskfaskkdfkddfaskfaskkfaskfaaaaaaskfaskkff";
		String needle = "aaaaaaskfaskkff";
		int result = strStr(haystack, needle);
		System.out.println(String.format("The result is %d", result));
	}
	public static int strStr(String haystack, String needle) {
        int j = 0;
        int i = 0;
        int[] nextval = getNextVal(needle);
        while(i < haystack.length() && j < needle.length()) {
        	if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
        		i ++;
        		j ++;
        	}
        	else
        	{
        		j = nextval[j];
        	}
        }
        if(j == needle.length())
        	return i - j;
        else
        	return -1;
    }
	
	public static int[] getNextVal(String needle) { // reference: http://www.cnblogs.com/yjiyjige/p/3263858.html
		int[] nextval = new int[needle.length()];
		int k = -1; // the first element of needle have no room for forward, so 0 - 1 = -1
		nextval[0] = -1;
		for(int j = 0; j < needle.length() - 1; ) {
			if(-1 == k || needle.charAt(j) == needle.charAt(k)) {
				//nextval[++j] = ++k; the skip problem if p[++j] == p[++k]
				if( needle.charAt(++j) == needle.charAt(++k)) // skipping avoid more useless step
					nextval[j] = nextval[k];
				else
					nextval[j] = k;
			}
			else
				k = nextval[k];
		}
		return nextval;
	}
}
