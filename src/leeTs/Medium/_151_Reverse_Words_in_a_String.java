package leeTs.Medium;

public class _151_Reverse_Words_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < 3)
			System.out.println(i ++);
	}

	public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = chars.length - 1; i < j; i ++, j --) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
        for(int start = chars.length - 1, end = start; start > 0;) {
            while(' ' == chars[end])
                end --;
            start = end;
            while(start > 0 && ' ' != chars[start - 1])
                start --;
            for(int i = start, j = end; i < end; i ++, j --) {
                chars[i] ^= chars[j];
                chars[j] ^= chars[i];
                chars[i] ^= chars[j];
            }
            end = start - 1;
        }
        return String.valueOf(chars);
    }
}
