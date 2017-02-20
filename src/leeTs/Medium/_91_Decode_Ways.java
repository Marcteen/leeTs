package leeTs.Medium;

public class _91_Decode_Ways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*It is a medium, so we must deal with the illegal input!!!*/
	public int numDecodings(String s) {
        if(null == s || 0 == s.length())
            return 0;
        int pre = 0, cur = 0, total = 0, single = 0, tailSum = 0;
        for(char c : s.toCharArray()) {
            cur = Character.getNumericValue(c);
            tailSum = 10 * pre + cur;
            if(0 == cur) {
                if(0 == single || tailSum > 20)/*Found a 00 or kinds of 70*/
                    return 0;
                total = single;
                single = 0;// latter element has no way to combine with cur
            }
            else {
                if(total == 0) {
                    total ++;
                    single ++;
                }
                else {
                    single = single - total;
                    if(tailSum < 27 && tailSum > cur) { // cur can be combined with pre
                        total = 2 * total + single;
                        single = (total - single) / 2;
                    }
                    else {
                        single = total;
                    }
                }
            }
            pre = cur;
        }
        return total;
    }
}
