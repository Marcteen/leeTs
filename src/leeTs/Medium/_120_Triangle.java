package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class _120_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(2);
	}
	
	public int minimumTotalDPNaturally(List<List<Integer>> triangle) {
        if(null == triangle || 0 == triangle.size())
            return 0;
        int size = triangle.size(), len = 0, val = 0;
        if(1 == triangle.size())
            return triangle.get(0).get(0);
        List<Integer> cur = null, next = triangle.get(size - 1);
        for(int i = size - 2; i >= 0; i --) {
            cur = triangle.get(i);
            len = cur.size();
            for(int j = 0; j < len; j ++) {
                val = cur.get(j);
                cur.set(j, Math.min(val + next.get(j), val + next.get(j + 1)));
            }
            next = cur;
        }
        return cur.get(0);
    }
	//Concern if not every row is increse by 1
	public int minimumTotalConcerned(List<List<Integer>> triangle) {
        if(null == triangle || 0 == triangle.size())
            return 0;
        List<Integer> cur = null, next = null;
        Iterator<List<Integer>> iter = triangle.iterator();
        int diff = 0, start = 0, num = 0;
        cur = iter.next();
        while(iter.hasNext()) {
            next = iter.next();
            diff = next.size() - cur.size();
            start = diff / 2;
            if(diff % 2 == 0) {// even increment, don't mistake with "/"
                for(int i = 0; i < cur.size(); i ++) {
                    num = next.get(start + i);
                    num += cur.get(i);
                    next.set(start + i, num);
                }
            }
            else {
                num = next.get(start);
                num += cur.get(0);
                next.set(start, num);
                num = next.get(start + 1);
                num += cur.get(0);
                next.set(start + 1, num);
                for(int i = 1; i < cur.size(); i ++) {
                    num = next.get(start + i);
                    //need compare with the former sum
                    next.set(start + i, Math.min(num, num - cur.get(i - 1) + cur.get(i)));
                    num = next.get(start + i + 1);
                    num += cur.get(i);
                    next.set(start + i + 1, num);
                }
            }
            cur = next;
        }
        diff = Integer.MAX_VALUE;
        for(int i : cur)
            if(i < diff)
                diff = i;
        return diff;
    }
}
