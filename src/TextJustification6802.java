import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/9/14.
 */
public class TextJustification6802 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int   N       = words.length;
        int[] lengths = new int[N];
        for (int i = 0; i < N; i++) {
            lengths[i] = words[i].length();
        }
        List<String> results = new ArrayList<>();
        int          start   = 0;
        while (start < N) {
            int sum = lengths[start];
            int end = start;
            for (int i = end + 1; i < N; i++) {
                if (sum + 1 + lengths[i] > maxWidth) {
                    break;
                } else {
                    end = i;
                    sum += (1 + lengths[i]);
                }
            }
            results.add(getStr(words, sum, start, end, maxWidth));
            start = end + 1;
        }
        return results;
    }

    private String getStr(String[] words, int lengthSum, int start, int end, int maxWidth) {
        StringBuilder sb       = new StringBuilder();
        int           spaceNum = end - start;
        if (spaceNum == 0) {
            return sb.append(words[start]).append(getSpace(maxWidth - lengthSum)).toString();
        }
        int extraSpace  = maxWidth - lengthSum;
        int fixedSpaces = 1;
        int lastExtra   = start - 1;
        if (spaceNum > 0 && extraSpace > 0 && end < (words.length - 1)) {
            fixedSpaces += extraSpace / spaceNum;
            lastExtra += extraSpace % spaceNum;
        }
        String repeats = getSpace(fixedSpaces);
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i < end) {
                sb.append(repeats);
                if (i <= lastExtra) {
                    sb.append(" ");
                }
            }
        }
        if (end == words.length - 1) {
            sb.append(getSpace(extraSpace));
        }
        return sb.toString();
    }

    private String getSpace(int num) {
        char[] repeatSpaces = new char[num];
        Arrays.fill(repeatSpaces, ' ');
        return new String(repeatSpaces);
    }

    public static void main(String[] args) {
        TextJustification6802 tj02     = new TextJustification6802();
        /*String[]              words    = {"This", "is", "an", "example", "of", "text", "justification."};
        int                   maxWidth = 16;*/
        String[] words = {"a", "b", "c", "d", "e"};
        int maxWidth = 3;
        /*String[] words = {"Here","is","an","example","of","text","justification."};
        int maxWidth = 14;*/
        List<String> justified = tj02.fullJustify(words, maxWidth);
        System.out.println(justified);
    }
}
