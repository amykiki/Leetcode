
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0) {
            return "";
        }
        else if (strs.length == 1) {
            return strs[0];
        }
        int length = strs[0].length();
        if (length == 0) return "";
        char s = strs[0].charAt(0);
        
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() > 0) {
                if (s != strs[i].charAt(0)) {
                    return prefix;
                }
                if (length > strs[i].length()) {
                    length = strs[i].length();
                }
            }
            else {
                return prefix;
            }
        }
        char[] pres = new char[length];
        pres[0] = s;
        for (int i = 1; i < length; i++) {
            s = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (s != strs[j].charAt(i)) {
                    prefix = new String(pres, 0, i);
                    return prefix;
                }
            }
            pres[i] = s;
        }
        prefix = new String(pres, 0, length);
        return prefix;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestCommonPrefix lcp = new LongestCommonPrefix();
//        String[] strs = new String[] {"aaaa", "aabb", "aaaabbb"};
        String[] strs = new String[] {};
        String prefix = lcp.longestCommonPrefix(strs);
        System.out.println(prefix);
    }

}
