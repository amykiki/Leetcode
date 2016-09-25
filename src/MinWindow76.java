import java.util.*;

/**
 * Created by Amysue on 2016/9/25.
 */
public class MinWindow76 {
    public String minWindow(String s, String t) {
        int N = t.length();
        TreeSet<Integer> set = new TreeSet<>();
        Map<Character, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char c = t.charAt(i);
            if (sizeMap.containsKey(c)) {
                int size = sizeMap.get(c);
                sizeMap.put(c, ++size);
            } else {
                sizeMap.put(c, 1);
            }
        }
        Map<Character, LinkedList<Integer>> map   = new HashMap<>(sizeMap.size());
        int                                 start = -1;
        int                                 len   = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!sizeMap.containsKey(c)) continue;
            addMap(set, map, sizeMap, c, i);
            if (set.size() == N) {
                int crtStart = set.first();
                int crtLen = i - crtStart + 1;
                if (start == -1) {
                    start = crtStart;
                    len = crtLen;
                } else if(crtLen < len){
                    start = crtStart;
                    len = crtLen;
                }
            }
        }
        if (start == -1) {
            return "";
        }
        return s.substring(start, len+start);
    }

    private void addMap(TreeSet<Integer> set, Map<Character, LinkedList<Integer>> map, Map<Character, Integer> sizeMap, char c, int index) {
        LinkedList<Integer> indexes;
        if (!map.containsKey(c)) {
            indexes = new LinkedList<>();
            indexes.add(index);
            map.put(c, indexes);
        } else {
            indexes = map.get(c);
            if (indexes.size() == sizeMap.get(c)) {
                Integer m = indexes.removeFirst();
                set.remove(m);
            }
            indexes.add(index);
        }
        set.add(index);
    }

    public static void main(String[] args) {
        MinWindow76 mw     = new MinWindow76();
        String      s      = "ADCBECODEBACC";
        String      t      = "ABCC";
        String      winstr = mw.minWindow(s, t);
        System.out.println("winstr = " + winstr);
    }
}
