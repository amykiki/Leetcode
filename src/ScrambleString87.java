import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ScrambleString87 {
    private String s1;
    private  String s2;
    public boolean isScramble(String s1, String s2) {
        if (s1 == s2 || s1.equals(s2)) {
            return true;
        }

        this.s1 = s1;
        this.s2 = s2;
        //查看两个字符串的字符数目是否相等
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            add(m1, s1.charAt(i));
            add(m2, s2.charAt(i));
        }
        if (!compareMap(m1, m2)) {
            return false;
        }
        return check(0, s1.length() - 1, 0, s2.length() - 1);
    }

    private boolean check(int start1, int end1, int start2, int end2) {
        if (end1 < start1 || end1 - start1 <= 2) { //如果比较字符数目小于等于3个，那个无论怎么排列都可以
            return true;
        }
        int low1 = start1;
        int high1 = end1;
        int low2 = start2;
        int high2 = end2;
        Map<Character, Integer> m1Low = new HashMap<>();
        Map<Character, Integer> m1High = new HashMap<>();
        Map<Character, Integer> m2Low = new HashMap<>();
        Map<Character, Integer> m2High = new HashMap<>();

        while (low1 < high1) {
            add(m1Low, s1.charAt(low1));
            add(m1High, s1.charAt(high1));
            add(m2Low, s2.charAt(low2));
            add(m2High, s2.charAt(high2));
            boolean low1low2 = compareMap(m1Low, m2Low);
            boolean low1High2 = compareMap(m1Low, m2High);
            while (low1low2 || low1High2) {
                if (low1low2) {
                    if (!check(start1, low1, start2, low2)) {
                        low1low2 = false;
                        continue;
                    }
                    if (!check(low1 + 1, end1, low2 + 1, end2)) {
                        low1low2 = false;
                        continue;
                    }
                    return true;
                }
                if (low1High2) {
                    if (!check(start1, low1, high2, end2)) {
                        return false;
                    }
                    return check(low1 + 1, end1, start2, high2 - 1);
                }
            }

            boolean high1low2 = compareMap(m1High, m2Low);
            boolean high1high2 = compareMap(m1High, m2High);
            while (high1low2 || high1high2) {
                if (high1low2) {
                    if (!check(high1, end1, start2, low2)) {
                        high1low2 = false;
                        continue;
                    }
                    if(!check(start1, high1 - 1, low2 + 1, end2)){
                        high1low2 = false;
                        continue;
                    }
                    return true;
                }
                if (high1high2) {
                    if (!check(high1, end1, high2, end2)) {
                        return false;
                    }
                    return check(start1, high1 - 1, start2, high2 - 1);
                }
            }
            low1++;
            high1--;
            low2++;
            high2--;
        }
        return false;
    }

    private void add(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        }else {
            map.put(c, 1);
        }
    }

    private boolean compareMap(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (char c : m1.keySet()) {
            if (!m2.containsKey(c) || m1.get(c) != m2.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static int getNum(Random random, char[] cs, int bound) {
        int num;
        while (true) {
            num = random.nextInt(bound);
            if (cs[num] == 0) {
                return num;
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();

        int len = 7;
        char[] c1 = new char[len];
        char[] c2 = new char[len];
        char[] cc = new char[26];
        int cnum;
        int num;
        for(int i = 0; i < len; i++) {
            cnum = getNum(random, cc, 26);
            cc[cnum] = (char) ('a' + cnum);
            num = getNum(random, c1, len);
            c1[num] = cc[cnum];
            num = getNum(random, c2, len);
            c2[num] = cc[cnum];
        }

        String s1 = new String(c1);
        String s2 = new String(c2);

//        s1 = "ygskbqo";
//        s2 = "kysbgqo";
        s1 = "hobobyrqd";
        s2 = "hbyorqdbo";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        ScrambleString87 ss = new ScrambleString87();
        System.out.println(ss.isScramble(s1, s2));

    }
}
