package leeTs.Medium;

public class _151_Reverse_Words_in_a_String {
	// I don't think it is normal to hide the requirement about removing redundant blank space, fuck leetcode
    public String reverseWords(String s) {
        if(null == s || 0 == s.length())
            return s;
        char[] result = deBlankSpace(s).toCharArray();
        reverseString(result, 0, result.length - 1);
        for(int start = 0, end = 0; end < result.length;) {// already remove redundant blank space, much easier
            while(end < result.length && ' ' != result[end])
                end ++;
            reverseString(result, start, end - 1);
            while(end < result.length && ' ' == result[end])
                end ++;
            //now end locates at next word's start if exist
            start = end;
        }
        return String.valueOf(result);
    }
    
    public String deBlankSpace(String input) {
        char[] str = input.toCharArray();
        int front = 0, behind = 0;//front seek the next word to be move, behind set to the last reciever start position
        // noted that behind can never go beyond front, if there is no redundent blank space, they will be at same position
        while(front < str.length && ' ' == str[front]) front ++;// find the first word's head
        while(front < str.length) {
            // find the start of next word
            while(front < str.length && ' ' != str[front]) str[behind ++] = str[front ++];// shift word until it reach blank space
            while(front < str.length && ' ' == str[front]) front ++;// seek for the next word
            if(front < str.length)// only in this way there is more word to be shift, otherwise the behind just locate at the beginning of black space suffix
                str[behind ++] = ' ';
        }
        // now the i just locate on the last position to be replace by non-blank space
        return String.valueOf(str).substring(0, behind);
    }
    
    public void reverseString(char[] str, int start, int end) {
        while(start < end) {
            str[start] ^= str[end];
            str[end] ^= str[start];
            str[start] ^= str[end];
            start ++;
            end --;
        }
    }
}
