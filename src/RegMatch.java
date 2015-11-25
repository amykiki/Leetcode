public class RegMatch {
    public boolean isMatch(String s, String p) {
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        if (s1.length == 0 || p1.length == 0) {
            return false;
        }
        if (p1[0] == '*') {
            return false;
        }
        char last = p1[0];
        int i = 0;
        int j = 0;
        int num = 0;
        while (i < s1.length && j < p1.length) {
            if (p1[j] == '.' || p1[j] == s1[i]) {
                last = p1[j];
                num = 1;
                i++;
                j++;
            }
            else if (p1[j] == '*') {
                if (last == s1[i] || last == '.') {
                    i++;
                    num++;
                }
                else {
                    j++;
                    int find = 0;
                    while (j < p1.length && num >= 0) {
                        if (p1[j] != last || p1[j] == '.') {
                            last = p1[j];
                            find = 1;
                            break;
                        }
                        num--;
                        j++;
                    }
                    if (find == 0) {
                        return false;
                    }
                    num = 0;
                }
            }
            else {
                if ((j+1) < p1.length && p1[j+1] == '*') {
                    last = p1[j];
                    j++;
                }
                else {
                    return false;
                }
            }
        }
        if (i == s1.length ) {
            if (j == p1.length) {
                return true;
            }
            else {
                j++;
                while (j < p1.length && num >= 0) {
                    while (j < p1.length) {
                        if (p1[j] != last) {
                            if ((j+1) < p1.length && p1[j+1] == '*') {
                                j++;
                            }
                            else {
                                return false;
                            }
                        }
                        else {
                            break;
                        }
                        j++;
                    }
                    if (j == p1.length) {
                        return true;
                    }
                    if (p1[j] == last || p1[j] == '.') {
                        num--;
                        j++;
                    }
                    else if (p1[j] == '*') {
                        j++;
                    }
                    else {
                        break;
                    }
                }
                if (j == p1.length && num >= 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RegMatch rm = new RegMatch();
//        String s = "aaa";
//        String p = "ab*a*c*a";
//        String s = "aaba";
//        String p = "ab*a*c*a";
//        String s = "a";
//        String p = ".*..a*";
        String s = "a";
        String p = "ab*";
        boolean ret = rm.isMatch(s, p);
        if (ret) {
            System.out.println("Match");
        }
        else {
            System.out.println("Not Match");
        }
    }

}
