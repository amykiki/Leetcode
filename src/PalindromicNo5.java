import java.awt.*;

/**
 * Created by Amysue on 2016/7/2.
 */
public class PalindromicNo5 {
    public String longestPalindrome(String s) {
        int low  = 0;
        int high = s.length() - 1;
        String palindstr1 = getPalindrome(s, low, high, "", "right");
        String palindstr2 = getPalindrome(s, low, high - 1, palindstr1, "left");
        if (palindstr1.length() < palindstr2.length()) {
            palindstr1 = palindstr2;
        }
        return palindstr1;
    }

    private String getPalindrome(String s, int low, int high, String palindstr, String dir) {
        if (high < low) return palindstr;
        if (high == low) {
            if (palindstr.equals("")) {
                return s.substring(low, high + 1);
            }
        }
        int     length = high - low + 1;
        if (palindstr.length() >= length) {
            return palindstr;
        }
        int     left, right;
        boolean match  = false;
        if (length % 2 == 1) {
            left = length / 2 - 1 + low;
            right = length / 2 + 1 + low;
        } else {
            left = length / 2 - 1 + low;
            right = length / 2 + low;
        }

        while (left >= low && right <= high) {
            if (s.charAt(left) == s.charAt(right)) {
                match = true;
                left--;
                right++;
            } else {
                break;
            }
        }
       /* System.out.println("low = " + low);
        System.out.println("high = " + high);*/
        if (match == true) {
            left++;
            right--;
           /* System.out.println("left = " + left);
            System.out.println("right = " + right);*/
            int matchLength = right - left + 1;
            if (matchLength > palindstr.length()) {
                palindstr = s.substring(left, right + 1);
            }
        }
//        System.out.println("==========================");
        String dirStr;
        if (dir.equals("left")) {
            dirStr = getPalindrome(s, low, high - 1, palindstr, dir);
        } else {
            dirStr = getPalindrome(s, low + 1, high, palindstr, dir);
        }

        if (palindstr.length() < dirStr.length()) {
            palindstr = dirStr;
        }
        return palindstr;
    }

    public static void main(String[] args) {
//        String str = "eabcdcbae";
//        String str = "eabaeeab";
        String str = "abcbe";
//        String str = "abcd";
        PalindromicNo5 palin = new PalindromicNo5();
        String palinstr = palin.longestPalindrome(str);
        System.out.println("*" + palinstr + "*");
    }


}
