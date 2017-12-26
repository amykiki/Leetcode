/**
 * 3ms版本，这个版本是网上的做法，记录下来，做为参考
 */
public class ScrambleString8702 {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n == 1) return s1.equals(s2);
        int[] map1 = new int[128], map2 = new int[128];
        for (int i = 0, cnt1 = 0, cnt2 = 0; i < n-1; i++) {
            if (map1[s1.charAt(i)]++ < 0) cnt1++;
            if (map1[s2.charAt(i)]-- > 0) cnt1++;
            if (cnt1 == i+1 &&
                    isScramble(s1.substring(0, cnt1), s2.substring(0, cnt1)) &&
                    isScramble(s1.substring(cnt1), s2.substring(cnt1))) return true;
            if (map2[s1.charAt(i)]++ < 0) cnt2++;
            if (map2[s2.charAt(n-1-i)]-- > 0) cnt2++;
            if (cnt2 == i+1 &&
                    isScramble(s1.substring(0, cnt2), s2.substring(n-cnt2)) &&
                    isScramble(s1.substring(cnt2), s2.substring(0, n-cnt2))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ScrambleString8702 ss = new ScrambleString8702();
        String s1 = "hobobyrqd";
        String s2 = "hbyorqdbo";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println(ss.isScramble(s1, s2));
    }
}
