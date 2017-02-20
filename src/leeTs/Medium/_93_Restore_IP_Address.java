package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;

public class _93_Restore_IP_Address {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "19216811";
		List<String> result = restoreIpAddresses(input);
	}
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4)
            return result;
        List<Integer> splits = new ArrayList(4);
        parse(s, 0, 3, "", result);
        return result;
    }
	public static void parse(String s, int start, int left, String parsed, List<String> result) {
        if(0 == left) {
            if('0' == s.charAt(start) && start + 1 != s.length())// start with zero and it is not the only left, illegal
                return;
            String curNumber = s.substring(start, s.length());// must take all remained character
            int num = Integer.parseInt(curNumber);
            if(num < 256) {
                result.add(parsed + "." + curNumber);
            }
        }
        else {
            int curNumber = 0;
            for(int i = 0; i < 3 && (i > 0 && curNumber > 0 || i == 0); i ++) {//Current number's length can be at most 3, and selected first zero cannot be extend
                int numRemainChar = s.length() - start - i - 1;
                /*No matter go on or skip it, we must absorb curNumber first!!!!!!!!!!!*/
                curNumber *= 10;
                curNumber += Character.getNumericValue(s.charAt(start + i));
                if(left * 3 < numRemainChar)// remain too much
                    continue;
                else
                    if(left > numRemainChar)
                        break;
                if(curNumber < 256)
                    if(parsed.equals(""))
                        parse(s, start + i + 1, left - 1, parsed + curNumber, result);
                    else
                        parse(s, start + i + 1, left - 1, parsed + "." + curNumber, result);
            }
        }
    }
}
