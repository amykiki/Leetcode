import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amysue on 2016/8/3.
 */
public class LetterCombinations17 {
    private Map<Character, Character[]> map = new HashMap<>(8);

    public List<String> letterCombinations(String digits) {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
        List<String> results = new ArrayList<>();
        int          start   = -1;
        int          count   = 0;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '0' && digits.charAt(i) != '1') {
                if (start == -1) {
                    start = i;
                }
                count++;
            } else {
                if (count > 0) {
                    char[] result = new char[count];
                    addChars(digits, start, start, start + count - 1, result, results);
                    count = 0;
                    start = -1;
                }
            }
        }
        if (count > 0) {
            char[] result = new char[count];
            addChars(digits, start, start, start + count - 1, result, results);
        }

        return results;
    }

    private void addChars(String digits, int i, int start, int high, char[] result, List<String> results) {
        char        c       = digits.charAt(i);
        Character[] letters = map.get(c);
        for (int j = 0; j < letters.length; j++) {
            result[i-start] = letters[j];
            if (i == high) {
                results.add(new String(result));
            } else {
                addChars(digits, i + 1, start, high, result, results);
            }
        }

    }


    public static void main(String[] args) {
        LetterCombinations17 lm      = new LetterCombinations17();
        List<String>         results = lm.letterCombinations("23045");
        System.out.println(results);

    }
}
