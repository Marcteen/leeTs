package leeTs.Hard;
import java.util.List;
import java.util.Iterator;
public class _57_Insert_Interval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int end = 0, pos = 0;
        Iterator lastIter = null;
        Iterator iter = intervals.iterator();
        Interval current = null, head = null;
        /* find the first maybe covered interval, just check its end
        with the new interval and determine the new start later*/
        while(iter.hasNext()) {
            current = (Interval)iter.next();
            if(current.end >= newInterval.start) {
                head = current;
                break;
            }
            pos ++;
        }
        // merge to the last covered interval
        if(head != null) {
            /*find the last cover interval and remove it one by one after the 
            head-interval, keep the real new end in each step*/
            end = newInterval.end;
            while(iter.hasNext()) {
                current = (Interval)iter.next();
                if(current.start <= newInterval.end) {
                	/*the real end for the merged interval*/
                    end = Math.max(current.end , newInterval.end);
                    iter.remove();
                } else
                    break;
            }
            /* the head may not covered for its start is greater
            the newInterval's end*/
            if(head.start > newInterval.end)
                intervals.add(pos, newInterval);
            else {
            /*Otherwise it is really covered, so just update its value
            is ok*/
                head.start = Math.min(newInterval.start, head.start);
                /*for the case that there is only one exist old interval*/
                head.end = end;
            }
        } else
            /*just append the new intervals and return*/
            intervals.add(newInterval);
        return intervals;
    }
}
