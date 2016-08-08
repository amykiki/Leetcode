import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Amysue on 2016/8/8.
 */
public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        int sum = 0;
        char[] ps = s.toCharArray();
//        System.out.println(Arrays.toString(ps));
        LinkedList<Integer> indexes = new LinkedList<>();
        for(int i = 0; i < ps.length; i++) {
            if (ps[i] == '(') {
                indexes.push(i);
            } else {
                if (!indexes.isEmpty()) {
                    int j = indexes.pop();
                    ps[j] = '1';
                    ps[i] = '1';
                }
            }
        }
//        System.out.println(Arrays.toString(ps));
        int count = 0;
        for(int i = 0; i < ps.length; i++) {
            if (ps[i] != '1') {
                if (count > 0) {
                    sum = Math.max(sum, count);
                }
                count = 0;
            } else {
                count++;
            }
        }
        if (count > 0) {
            sum = Math.max(sum, count);
        }
        return sum;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 lvp = new LongestValidParentheses32();
//        String s = "(((()()((((((())))))))((((((((((()()())))()()";
//        String s = ")()())";
        String s = "(((((((((((((((((((((((((()";
        int num = lvp.longestValidParentheses(s);
        System.out.println("num = " + num);
    }
}
