package leeTs.Medium;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class _56_Merge_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	// remove unnecessary outer loop
	public List<Interval> mergeNeat(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(null == intervals)
            return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval foo, Interval bar) {
                int result = Integer.compare(foo.start, bar.start);
                return result == 0 ? Integer.compare(foo.end, bar.end) : result;
        }
        });
        Iterator<Interval> iter = intervals.iterator();
        Interval prefix = null, cur = null;
        if(iter.hasNext()) {
            prefix = iter.next();
            while(iter.hasNext()) {
                cur = iter.next();
                if(cur.start <= prefix.end) {
                    if(cur.end > prefix.end)
                        prefix.end = cur.end;
                }
                else {
                    result.add(prefix);
                    prefix = cur;
                }
            }
            result.add(prefix);
        }
        return result;
    }
	
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(null == intervals)
            return result;
        Interval prefix = null, tail = null;
        int j = 0, farthestEnd = 0;
        Collections.sort(intervals, new IntervalComparator());
        for(int i = 0; i < intervals.size();) {
            prefix = intervals.get(i);
            farthestEnd = prefix.end;
            if(i < intervals.size() - 1) {// may have sth to extend
                for(j = i + 1; j < intervals.size(); j ++) {//extend or cut
                    tail = intervals.get(j);
                    if(tail.start > farthestEnd)// prefix or early interval may cover several followers, so dynamic enlarge it if possible
                        break;
                    else
                        if(tail.end > farthestEnd)
                            farthestEnd = tail.end;
                }
                prefix.end = farthestEnd;
                i = j;// be careful the increasement's combination with if-else logic block !!!!!!!! loop may stuck.
            }
            else
                i ++;
            result.add(prefix);
        }
        return result;
    }
    static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval foo, Interval bar) {
            int result = Integer.compare(foo.start, bar.start);
            return result == 0 ? Integer.compare(foo.end, bar.end) : result;
        }
    }
}
