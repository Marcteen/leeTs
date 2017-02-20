package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;

public class _89_Gray_Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Construct by adding new digit = 1
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>((int)Math.pow(2, n));
        result.add(0);
        if(0 == n)
            return result;
        result.add(1);
        int max = (int)Math.pow(2, n - 1), tail = 0;
        for(int prefix = 2; prefix <= max; prefix *= 2) {// add "1" bit to current digits inversely, just right.....
            tail = result.size() - 1;
            for(;tail >= 0; tail --) {
                result.add(prefix + result.get(tail));
            }
        }
        return result;
    }
    
    public List<Integer> grayCodeEval(int n) {
        List<Integer> result = new ArrayList<>((int)Math.pow(2, n));
        result.add(0);
        int all = (int)Math.pow(2, n) - 1;
        for(int i = 1; i <= all; i ++)
            result.add(i ^ (i >> 1));
        return result;
    }
}
