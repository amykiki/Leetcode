
public class LongestPalindromeStr {
    public String longestPalindrome(String s) {
        String pal = "";
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i >= 0; i--) {
            int len = i + 1;
            int middle = len / 2;
            int size = findPalindrome(str, middle, len);
            if (size > pal.length()) {
                int low = middle - size/2;
                int high = middle + size/2;
                if (len %2 == 1) {
                    high += 1;
                }
                if (high > low) {
                    pal = s.substring(low, high);
                }
            }
            if (pal.length() >= len) {
                break;
            }
        }
        for (int i = 1; i < str.length; i++) {
            int len = str.length - i;
            int middle = len/2 + i;
            int size = findPalindrome(str, middle, len);
            if (size > pal.length()) {
                int low = middle - size/2;
                int high = middle + size/2;
                if (len %2 == 1) {
                    high += 1;
                }
                if (high > low) {
                    pal = s.substring(low, high);
                }
            }
            if (pal.length() >= len) {
                break;
            } 
        }
        return pal;
    }
    private int findPalindrome(char[] s, int middle, int len) {
        int left = 0;
        int right = 0;
        int size = 0;
        if (len % 2 == 0) {
            left = middle - 1;
            right = middle;
        }
        else {
            left = middle - 1;
            right = middle + 1;
            size = 1;
        }
        while ((right - left) < len) {
            if (s[left] == s[right]) {
                left--;
                right++;
                size += 2;
            }
            else {
                break;
            }
        }
        return size;
    }
    
    public static void main(String[] args) {
        String s = "iiibcdedcbgdfejikk";
//        String s = "ieiiiii";
//        char[] str = s.toCharArray();
        LongestPalindromeStr lps = new LongestPalindromeStr();
//        int len = 5;
//        int middle = 11;
//        int ret = lps.findPalindrome(str, middle, len);
//        System.out.println("ret = " + ret);
        String pal = lps.longestPalindrome(s);
        System.out.println(pal);
    }
}
