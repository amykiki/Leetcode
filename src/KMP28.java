import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/8/4.
 */
public class KMP28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }
        int M = needle.length();
        int[]         lens = new int[M];
        genLenArray(needle, lens);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < M) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lens[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == M) {
            return i - M;
        } else {
            return  -1;
        }
    }

    private void genLenArray(String pattern, int[] lens) {
        lens[0] = 0;
        int len = 0;
        int i   = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(len) == pattern.charAt(i)) {
                lens[i] = len + 1;
                i++;
                len++;
            } else {
                if (len > 0) {
                    len = lens[len - 1];
                } else {
                    lens[i] = 0;
                    i++;
                }
            }
        }
    }

    private boolean emptyStr(String string) {
        if (string == null || string.trim().equals("")) {
            return true;
        }
        return false;
    }

    public List<Integer> hits(String str, String pattern) {
        if (emptyStr(str) || emptyStr(pattern)) {
            return null;
        }
        List<Integer> hits = new ArrayList<>();
        int M = pattern.length();
        int[]         lens = new int[M];
        genLenArray(pattern, lens);
        System.out.println(Arrays.toString(lens));
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lens[j - 1];
                } else {
                    i++;
                }
            }
            if (j == M) {
                hits.add(i - M);
                j = lens[j - 1];
            }
        }
        if (hits.isEmpty()) {
            return null;
        } else {
            return hits;
        }
    }

    public static void main(String[] args) {
        KMP28         kmp     = new KMP28();
        String        pattern = "abaab";
        String        str     = "ababaababaabcacabaaaabaab";
        List<Integer> hists   = kmp.hits(str, pattern);
        System.out.println(hists);
        int hit = kmp.strStr(str, pattern);
        System.out.println("hit = " + hit);
    }
}
