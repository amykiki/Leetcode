import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amysue on 2016/9/14.
 */
public class TextJustification68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int N = words.length;
        int[] lengths = new int[N];
        for(int i = 0; i < N; i++) {
            lengths[i] = words[i].length();
        }
        int[][] dp = getDP(lengths, maxWidth);
        int[] indexes = new int[N + 1];
        int[] values = new int[N + 1];
        for(int i = N - 1; i >= 0; i-- ) {
            int value = dp[i][i] + values[i+1];
            int index = i + 1;
            for(int j = i + 1; j < N; j++ ) {
                if (dp[i][j] == -1) {
                    break;
                }
                int nextValue = dp[i][j] + values[j + 1];
                if (nextValue <= value) {
                    value = nextValue;
                    index = j+1;
                }
            }
            values[i] = value;
            indexes[i] = index;
        }
        int m = 0;
        List<String> results = new ArrayList<>();
        while (m < N) {
            int end = indexes[m] - 1;
            String str = getStr(words, lengths, m, end, maxWidth);
            results.add(str);
            m = end + 1;
        }
        return results;
    }
    private String getStr(String[] words, int[] lengths, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int spaceNum = end - start;
        if (spaceNum == 0) {
            return sb.append(words[start]).append(getSpace(maxWidth - lengths[start])).toString();
        }
        int lengthSum = spaceNum;
        for(int i = start; i <= end; i++) {
            lengthSum += lengths[i];
        }
        int extraSpace = maxWidth - lengthSum;
        int fixedSpaces = 1;
        int lastExtra = start - 1;
        if (spaceNum > 0 && extraSpace > 0 && end < (words.length-1)) {
            fixedSpaces += extraSpace/spaceNum;
            lastExtra += extraSpace%spaceNum;
        }
        String repeats = getSpace(fixedSpaces);
        for(int i = start; i <= end; i++) {
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
    private int[][] getDP(int[] lengths, int maxWidth) {
        int N = lengths.length;
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum += lengths[j];
                if (sum > maxWidth) {
                    dp[i][j] = -1;
                    break;
                }
                dp[i][j] = (int)Math.pow(maxWidth - sum, 2);
                sum +=1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        TextJustification68 tj = new TextJustification68();
       /* String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;*/
        String[] words = {"Here","is","an","example","of","text","justification."};
        int maxWidth = 14;
        List<String> justified = tj.fullJustify(words, maxWidth);
        System.out.println(justified);
    }
}
