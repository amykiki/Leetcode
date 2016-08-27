import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amysue on 2016/8/26.
 */
public class InsertInterval57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        int            starti  = findKey(intervals, newInterval.start);
        int            low     = newInterval.start;
        if (starti >= 0) {
            if (low <= intervals.get(starti).end) {
                low = intervals.get(starti).start;
            } else {
                starti += 1;
            }
        }
        if (starti >= intervals.size()) {
            intervals.add(newInterval);
            return intervals;
        }
        int endi = findKey(intervals, newInterval.end);
        if (endi < 0) {
            intervals.add(0, newInterval);
            return intervals;
        }
        int high = newInterval.end;
        if (high <= intervals.get(endi).end) {
            high = intervals.get(endi).end;
        }
        if (starti > 0) {
            results.addAll(intervals.subList(0, starti));
        }
        results.add(new Interval(low, high));
        results.addAll(intervals.subList(endi + 1, intervals.size()));

        return results;
    }

    private int findKey(List<Interval> intervals, int key) {
        int low    = 0;
        int high   = intervals.size() - 1;
        int middle = 0;
        while (low <= high) {
            middle = low + (high - low) / 2;
            int value = intervals.get(middle).start;
            if (value < key) {
                low = middle + 1;
            } else if (value > key) {
                high = middle - 1;
            } else {
                break;
            }
        }
        if (low <= high) {
            return middle;
        } else {
            return high;
        }
    }

    public static void main(String[] args) {
        InsertInterval57 iit       = new InsertInterval57();
        List<Interval>   intervals = new ArrayList<>();
        int[]            starts    = {1, 3, 6, 8, 17};
        int[]            ends      = {2, 5, 7, 10, 20};
        for (int i = 0; i < starts.length; i++) {
            intervals.add(new Interval(starts[i], ends[i]));
        }
        int low = 13;
        int high = 16;
        Interval       newInterval = new Interval(low, high);
        System.out.println(intervals);
        System.out.println(newInterval);
        List<Interval> results     = iit.insert(intervals, newInterval);
        System.out.println(results);
    }
}
