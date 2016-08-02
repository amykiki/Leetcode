import java.util.LinkedList;

/**
 * Created by Amysue on 2016/8/2.
 */
public class WildcardMatch4402 {
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
        char[]                str  = s.toCharArray();
        char[]                pstr = p.toCharArray();
        LinkedList<Character> ps   = new LinkedList<>();
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
        i = 0;
        int j = 0;
        int starp = -1;
        int si = -1;

        while (i < str.length) {
            if (j < pstr.length) {
                if (pstr[j] == str[i] || pstr[j] == '?') {
                    i++;
                    j++;
                } else if (pstr[j] == '*') {
                    si = i;
                    starp = ++j;
                } else if (starp >= 0) {
                    i = ++si;
                    j = starp;
                } else {
                    j = -1;
                }
            } else {
                if (pstr[j - 1] == '*') {
                    return true;
                } else if (starp >= 0) {
                    i = ++si;
                    j = starp;
                } else {
                    j = -1;
                }
            }
            if (j == -1) {
                return false;
            }
        }

        if (j == pstr.length || (j == pstr.length - 1 && pstr[j] == '*')) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        WildcardMatch4402 wm = new WildcardMatch4402();
//                String s = "aab";
//        String p = "c*a*b";
//        String s = "aaa";
//        String p = "a?";
//        String s = "abcdefg";
//        String p = "*a*b*c*d*efgh";
//        String s = "aaba";
//        String p = "ab*a*c*a";
        String s = "aac";
        String p = "*ac";
//        String s = "ab";
//        String p = "*?";
//        String s = "aaaa";
//        String p = "*a*";
        System.out.println(wm.isMatch(s, p));
    }
}
