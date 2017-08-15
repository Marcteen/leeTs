package leeTs.Hard;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _68_Text_Justification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[]{""};//{"a", "b", "c", "d", "e"};
		List<String> result = fullJustify(input, 0);
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
        if(null == words)
            return null;
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int accumulate = -1, last = 0, numSpaces = 0, interval = 0, count = 0, reminder = 0;
        char[] spaces = null;
        for(int i = 0; i < words.length;) {
            /*grab a leading word for each line*/
            accumulate = words[i].length();
            last = i ++;
            /*use a loop inside a not step-by-step loop
            avoid the tail-clean up after the whole loop!!*/
            for(;i < words.length && accumulate + words[i].length() + 1 <= maxWidth; i ++) {
                accumulate += words[i].length() + 1;
            }
            builder.delete(0, builder.length());
            count = i - last;
            /*if not tailing word, we simply add all space to the last, the accumulate
            count one more space for each tailing word, so correct it*/
            numSpaces = maxWidth - accumulate + count - 1;
            /*for the last line and only one word to append, use the last justification*/
            if(i == words.length || count == 1) {
                for(; last < i; last ++) {
                    builder.append(words[last] + " ");
                }
                builder.delete(builder.length() - 1, builder.length());
                while(builder.length() < maxWidth)
                    builder.append(' ');
                result.add(builder.toString());
            } else {
                builder.append(words[last ++]);
                count --;
                /*if we can't divide numSpaces evenly, we can just
                evenly put reminder to the left part of the line!!!!*/
                reminder = numSpaces % count;
                interval = numSpaces / count;
                spaces = new char[interval];
                Arrays.fill(spaces, ' ');
                for(; last < i; last ++) {
                    if(reminder > 0) {
                        builder.append(' ');
                        reminder --;
                    }
                    builder.append(new String(spaces) + words[last]);
                }
                result.add(builder.toString());
            }
        }
        return result;
    }
}
