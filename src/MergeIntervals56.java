import java.util.*;

/**
 * Created by Amysue on 2016/8/25.
 */
class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.end < o2.end) {
            return -1;
        } else if (o1.end > o2.end) {
            return 1;
        }
        return 0;
    }
}
public class MergeIntervals56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.size() <= 1) {
            return intervals;
        }
        int N = intervals.size() - 1;
        Comparator<Interval> cp = new IntervalComparator();
        Collections.sort(intervals, cp);
        LinkedList<Interval> result = new LinkedList<>();
        Interval crt = intervals.get(N);
        int high = crt.end;
        int low = crt.start;
        for(int i = N-1; i>= 0; i--) {
            Interval iter = intervals.get(i);
            if (iter.end < low) {
                result.push(new Interval(low, high));
                low = iter.start;
                high = iter.end;
            } else {
                if (iter.start < low) {
                    low = iter.start;
                }
            }

        }
        result.push(new Interval(low, high));
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals56 mi = new MergeIntervals56();
        List<Interval> intervals = new ArrayList<>();
//        int[] starts = {1, 2, 10, 15, 7};
//        int[] ends = {3, 8, 13, 18, 11};
        int[] starts = {1, 2, 8,15};
        int[] ends = {3,6,10,18};
//        int[] starts = {1, 1,1,1};
//        int[] ends = {2,2,2,2};
       /* intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 8));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(15, 18));*/
       for(int i = 0; i < starts.length; i++) {
           Interval iter = new Interval(starts[i], ends[i]);
           intervals.add(iter);
       }
        System.out.println(intervals);
        List<Interval> results = mi.merge(intervals);
        System.out.println(results);

    }
}
