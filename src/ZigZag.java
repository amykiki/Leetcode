
public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        String result = "";
        char[] str = new char[s.length()];
        char[] origin = s.toCharArray();
        int n = 0;
        int group = (numRows*2 - 2);
        int numGroup = s.length() / group;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= numGroup; j++) {
                int k = j* group;
                if ((k + i) < s.length()) {
                    str[n++] = origin[k + i];
                    if ((k + group - i) < s.length()) {
                        if (i > 0 && i < (numRows - 1)) {
                            str[n++] = origin[k + group - i];
                        }
                    }
                }
            }
        }
        result = new String(str);
        return result;
    } 
    public static void main(String[] args) {
        ZigZag zz = new ZigZag();
        String s = "PAYPALISHIRINGMNQPT";
        String ret = zz.convert(s, 3);
        System.out.println("ret = " + ret);

    }

}
