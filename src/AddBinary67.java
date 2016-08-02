/**
 * Created by Amysue on 2016/8/2.
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        char[] astr = a.toCharArray();
        char[] bstr = b.toCharArray();
        if (astr.length < bstr.length) {
            char[] tmp = astr;
            astr = bstr;
            bstr = tmp;
        }
        char[] sum = new char[astr.length + 1];
        int i = astr.length - 1;
        int j = bstr.length - 1;
        int s = 0;
        while (j >= 0) {
            s = add(astr[i] - '0', bstr[j] - '0', s, sum, i+1);
            i--;
            j--;
        }
        while (i >= 0) {
            s = add(astr[i] - '0', 0, s, sum, i+1);
            i--;
        }
        if (s == 1) {
            sum[0] = (char) (s + '0');
            return new String(sum);
        } else {
            return new String(sum, 1, astr.length);
        }
    }

    private int add(int a, int b, int s, char[] sum, int i) {
        s += a + b;
        sum[i] = (char) (s % 2 + '0');
        return s/2;
    }

    public static void main(String[] args) {
        AddBinary67 ab = new AddBinary67();
        String a = "100000000000000";
        String b = "111111111111111";
        String sum = ab.addBinary(a, b);
        System.out.println("sum = " + sum);
    }
}
