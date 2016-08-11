/**
 * Created by Amysue on 2016/8/11.
 */
public class CountAndSay38 {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1; i < n; i++) {
            result = convert(result);
        }
        return result;
    }

    private String convert(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int N = str.length() - 1;
        while (i < str.length()) {
            int count = 1;
            while (i < N && str.charAt(i + 1) == str.charAt(i)) {
                i++;
                count++;
            }
            sb.append(Integer.toString(count));
            sb.append(str.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay38 cs = new CountAndSay38();
        int n = 6;
        String result = cs.countAndSay(n);
        System.out.println("result = " + result);
    }

}
