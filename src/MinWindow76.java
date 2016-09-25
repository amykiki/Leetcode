import java.util.*;

/**
 * Created by Amysue on 2016/9/25.
 */
public class MinWindow76 {
    public String minWindow(String s, String t) {
        int N = t.length();
        List<Integer>           list    = new ArrayList<>(N);
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
            addMap(list, map, sizeMap, c, i);
            if (list.size() == N) {
                int crtStart = list.get(0);
                int crtLen = list.get(N-1) - crtStart + 1;
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

    private void addMap(List<Integer> list, Map<Character, LinkedList<Integer>> map, Map<Character, Integer> sizeMap, char c, int index) {
        LinkedList<Integer> indexes;
        if (!map.containsKey(c)) {
            indexes = new LinkedList<>();
            indexes.add(index);
            map.put(c, indexes);
        } else {
            indexes = map.get(c);
            if (indexes.size() == sizeMap.get(c)) {
                Integer m = indexes.removeFirst();
                list.remove(m);
            }
            indexes.add(index);
        }
        list.add(index);
    }

    public static void main(String[] args) {
        MinWindow76 mw     = new MinWindow76();
        String      s      = "ADCBECODEBACC";
        String      t      = "ABCC";
        String      winstr = mw.minWindow(s, t);
        System.out.println("winstr = " + winstr);
    }
}
