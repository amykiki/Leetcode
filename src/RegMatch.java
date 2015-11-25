public class RegMatch {
    public boolean isMatch(String s, String p) {
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        if (p1[0] == '*') {
            return false;
        }
        char last = p1[0];
        int i = 0;
        int j = 0;
        boolean result = false;
        while (i < s1.length && j < p1.length) {
            if (p1[j] == '.') {
                last = '.';
                i++;
                j++;
            }
            else if (p1[j] == s1[i]) {
                last = p1[j];
                j++;
                i++;
            }
            else if (p1[j] == '*') {
                if (last == s1[i] || last == '.') {
                    i++;
                }
                else {
                    j++;
                    if (j < p1.length) {
                        
                    }
                    else {
                        return false;
                    }
                     
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RegMatch rm = new RegMatch();
        String s = "aaa";
        String p = "a*";
        boolean ret = rm.isMatch(s, p);
        if (ret) {
            System.out.println("Match");
        }
        else {
            System.out.println("Not Match");
        }
    }

}
