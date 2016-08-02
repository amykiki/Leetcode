import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Amysue on 2016/8/2.
 */
public class WildcardMatch44 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (p.isEmpty()) {
            return false;
        }
        char[] str = s.toCharArray();
        char[] pstr = p.toCharArray();
        LinkedList<Character> ps = new LinkedList<>();
        for(int i = 0; i < pstr.length; i++) {
            if (ps.isEmpty() || pstr[i] != '*' || ps.peek() != '*' ) {
                ps.push(pstr[i]);
            }
        }
        pstr = new char[ps.size()];
        int i = ps.size() - 1;
        while (i >= 0) {
            pstr[i] = ps.pop();
            i--;
        }
        int M = pstr.length;
        Set<Integer> nextStates = new HashSet<>();
        nextStates.add(0);
        if (pstr[0] == '*') {
            nextStates.add(1);
        }
        for(i = 0; i < str.length; i++) {
            Set<Integer> match = new HashSet<>();
            for (int j : nextStates) {
                if (j < M) {
                    if (pstr[j] == str[i] || pstr[j] == '?' || pstr[j] == '*') {
                        match.add(j + 1);
                        if (pstr[j] == '*') {
                            match.add(j);
                        }
                        if ((j + 1) < M && pstr[j + 1] == '*') {
                            match.add(j + 2);
                        }
                    }
                }
            }
            if (match.isEmpty()) {
                return false;
            }
            nextStates = match;
        }
        for (int j : nextStates) {
            if (j == M) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WildcardMatch44 wm = new WildcardMatch44();
//        String s = "aab";
//        String p = "c*a*b";
//        String s = "aaa";
//        String p = "a?";
//        String s = "aaa";
//        String p = "ab*a*c*a";
//        String s = "aaba";
//        String p = "ab*a*c*a";
//        String s = "aab";
//        String p = "a*b";
        String s = "aaa";
        String p = "a*";
        System.out.println(wm.isMatch(s, p));
    }
}
