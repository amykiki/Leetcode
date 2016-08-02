/**
 * Created by Amysue on 2016/8/2.
 */
public class LongestPalindromeStr05 {
    public String longestPalindrome(String s) {
        String palin = "";
        int    high  = s.length() - 1;
        int    len   = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (find(palin, len)) {
                break;
            }
            palin = getPalindrome(str, 0, high - i, palin);
            if (find(palin, len)) {
                break;
            }
            if (i > 0) {
                palin = getPalindrome(str, i, high, palin);
            }
            len--;
        }
        return palin;
    }

    private boolean find(String palin, int len) {
        if (len == 0 || palin.length() >= len) {
            return true;
        }
        return false;
    }

    private String getPalindrome(char[] s, int low, int high, String palin) {
        if (low == high) {
            return new String(s, low, 1);
        }
        int middle = (high - low)/2 + low;
        int left, right;
        int count = 0;
        if ((high - low + 1) % 2 == 0) {
            left = middle;
            right = middle + 1;
        } else {
            left = middle - 1;
            right = middle + 1;
            count = 1;
        }
        while (left >= low) {
            if (s[left] == s[right]) {
                left--;
                right++;
                count += 2;
            } else {
                break;
            }
        }
        if (find(palin, count)) {
            return palin;
        } else {
            return new String(s, left + 1, count);
        }
    }

    public static void main(String[] args) {
        LongestPalindromeStr05 lp = new LongestPalindromeStr05();
        String                 s  = "acabcdefg";
        System.out.println(lp.longestPalindrome(s));
    }
}
