
public class StrToInt {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] s = str.toCharArray();
        int i = 0;
        while (Character.isWhitespace(s[i])) {
            i++;
        }
        int signal = 1;
        int sum = 0;
        int bound = Integer.MAX_VALUE;
        if (s[i] == '+') {
            signal = 1;
        }
        else if (s[i] == '-') {
            signal = -1;
            bound = Integer.MIN_VALUE;
        }
        else if (s[i] > 57 || s[i] < 48) {
            return 0;
        }
        else {
            sum = s[i] - 48;
        }
        i++;
        while (i < s.length) {
            int j = s[i] - 48;
            if (j > 9 || j < 0) {
                break;
            }
            j = j*signal;
            int k = (bound - j)/10;
            if (k > sum && signal < 0) {
                return bound;
            }
            if (k < sum && signal > 0) {
                return bound;
            }
            sum = j + sum*10;
            i++;
        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StrToInt sti = new StrToInt();
        int ret = sti.myAtoi("-21.55");
        System.out.println("ret = " + ret);
    }

}
