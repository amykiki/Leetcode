import java.util.*;

/**
 * Created by Amysue on 2016/8/1.
 */
public class REsMatch10 {
    public boolean isMatch(String s, String p) {
        p = "(" + p + ")";
        char[] re = p.toCharArray();
        Map<Integer, List<Integer>> conn = getConn(re);
        Set<Integer> indexes = new HashSet<>();
        indexes.add(0);
        Set<Integer> nextStates = getStates(conn, indexes);
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            Set<Integer> match = new HashSet<>();
            for (int j : nextStates) {
                if (j < re.length) {
                    if (re[j] == str[i] || re[j] == '.') {
                        match.add(j + 1);
                    }
                }
            }
            nextStates = getStates(conn, match);
        }
        for (int i : nextStates) {
            if (i == re.length) {
                return true;
            }
        }
        return false;
    }

    private Set<Integer> getStates(Map<Integer, List<Integer>> conn, Set<Integer> indexes) {
        Set<Integer> nextStates = new HashSet<>();
        for (int index : indexes) {
            nextStates.add(index);
            addStates(nextStates, conn, index);
        }
        return nextStates;
    }

    private void addStates(Set<Integer> nextStates, Map<Integer, List<Integer>> conn, int index) {
        if (conn.containsKey(index)) {
            for (int i : conn.get(index)) {
                nextStates.add(i);
                if (i > index) {
                    addStates(nextStates, conn, i);
                }
            }
        }
    }

    private Map<Integer, List<Integer>> getConn(char[] re) {
        Map<Integer, List<Integer>> states = new HashMap<>();
        for(int i = 0; i < re.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (re[i] == '(' || re[i] == ')' || re[i] == '*') {
                if (i > 0 && re[i] == '*') {
                    list.add(i - 1);
                }
                list.add(i + 1);
            }
            if (i < re.length - 1 && re[i + 1] == '*') {
                list.add(i + 1);
            }
            if (!list.isEmpty()) {
                states.put(i, list);
            }
        }
        return states;
    }

    public static void main(String[] args) {
        REsMatch10 match = new REsMatch10();
//        String s = "aab";
//        String p = "c*a*b";
//        String s = "a";
//        String p = "aa";
//        String s = "aaa";
//        String p = "ab*a*c*a";
//        String s = "aaba";
//        String p = "ab*a*c*a";
        String s = "a";
        String p = ".*.a*";
        System.out.println(match.isMatch(s, p));

    }
}
