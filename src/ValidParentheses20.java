import java.util.LinkedList;

/**
 * Created by Amysue on 2016/8/3.
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        LinkedList<Character> ps = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                ps.push(c);
            } else {
                if (c == ')') {
                    if (ps.isEmpty() || ps.peek() != '(') {
                        return false;
                    } else {
                        ps.pop();
                    }
                }
                else if (c == ']') {
                    if (ps.isEmpty() || ps.peek() != '[') {
                        return false;
                    } else {
                        ps.pop();
                    }
                }
                else if (c == '}') {
                    if (ps.isEmpty() || ps.peek() != '{') {
                        return false;
                    } else {
                        ps.pop();
                    }
                }
            }
        }
        if (!ps.isEmpty()) {
            return false;
        }
        return true;
    }
}
