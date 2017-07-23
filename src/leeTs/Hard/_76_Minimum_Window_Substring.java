package leeTs.Hard;
import java.util.HashMap;

public class _76_Minimum_Window_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> note = new HashMap<>();
		Integer a = 0, b = a;
		a ++;
		b ++;
		System.out.println(b);
	}
	public String minWindow(String s, String t) {
        HashMap<Character, Integer> note = new HashMap<>();
        int numChar = t.length(), head = 0, tail = 0, num = 0, start = 0, length = Integer.MAX_VALUE;
        char c = 0;
        for(char ci : t.toCharArray()) {
            if(!note.containsKey(ci))
                note.put(ci, Integer.valueOf(1));
            else
                note.put(ci, note.get(ci) + 1);
        }
        while(tail < s.length()) {
            /*use the outer loop to add new char each step, 
            then performing the shrinking use an inner loop*/
            c = s.charAt(tail ++);
            if(note.containsKey(c)) {
                num = note.get(c) - 1;
                note.put(c, num);
                if(0 == num)
                    numChar --;
            }
            while(numChar == 0) {
                start = head;
                if(tail - head + 1 < length)
                    length = tail - head + 1;
                c = s.charAt(head ++);
                if(note.containsKey(c)) {
                    num = note.get(c) + 1;
                    note.put(c, num);
                    if(1 == num)
                        numChar ++;
                }
            }
        }
        return s.substring(start, start + length);
    }
}
