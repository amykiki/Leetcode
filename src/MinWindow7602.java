import java.util.*;

/**
 * Created by Amysue on 2016/9/25.
 */
public class MinWindow7602 {
    private int count = 0;
    private int sum   = 0;
    private String str;

    public String minWindow(String s, String t) {
        sum = t.length();
        str = s;
        List<Integer>           list    = new ArrayList<>();
        Map<Character, Integer> sizeMap = new HashMap<>();
        Map<Character, Integer> map     = new HashMap<>();
        for (int i = 0; i < sum; i++) {
            char c = t.charAt(i);
            if (sizeMap.containsKey(c)) {
                int size = sizeMap.get(c);
                sizeMap.put(c, ++size);
            } else {
                sizeMap.put(c, 1);
                map.put(c, 0);
            }
        }
        int start  = -1;
        int len    = s.length() + 1;
        int offset = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!sizeMap.containsKey(c)) continue;
            int lastOffset = offset;
            offset = addMap(list, map, sizeMap, c, i, offset);
            if (lastOffset == offset && start >= 0) continue;
            if (count == sum) {
                int crtStart = list.get(offset);
                int crtLen   = i - crtStart + 1;
                if (crtLen < len) {
                    start = crtStart;
                    len = crtLen;
                }
                if (len == sum) {
                    break;
                }
            }
        }
        if (start == -1) {
            return "";
        }
        return s.substring(start, len + start);
    }

    private int addMap(List<Integer> list, Map<Character, Integer> map, Map<Character, Integer> sizeMap, char c, int index, int offset) {
        int num = map.get(c);
        map.put(c, ++num);
        if (num <= sizeMap.get(c)) {
            count++;
        }
        list.add(index);
        if (count == sum) {
            char cstart = str.charAt(list.get(offset));
            while (map.get(cstart) > sizeMap.get(cstart)) {
                offset++;
                map.put(cstart, map.get(cstart) - 1);
                cstart = str.charAt(list.get(offset));
            }
        }
        return offset;
    }

    public static void main(String[] args) {
        MinWindow7602 mw = new MinWindow7602();
        String        s  = "ADCBECODEBACC";
        String        t  = "ABCC";
//        String        s      = "aa";
//        String        t      = "aa";
        String winstr = mw.minWindow(s, t);
        System.out.println("winstr = " + winstr);
    }
}
