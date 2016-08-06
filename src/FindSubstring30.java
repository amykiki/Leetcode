import java.util.*;

/**
 * Created by Amysue on 2016/8/6.
 */
public class FindSubstring30 {
    private Map<String, Integer> wordsMap = new HashMap<>();
    private Map<String, Integer> hitCounts = new HashMap<>();
    private LinkedList<String>   hit      = new LinkedList<>();
    private int                  M        = 0;  //single word length
    private int                  N        = 0;  // words numbers
    private int                  sLen     = 0;
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return results;
        }
        this.N = words.length;
        this.M = words[0].length();
        if (s.length() < M * N) {
            return results;
        }
        this.sLen = s.length();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                int t = wordsMap.get(word);
                wordsMap.put(word, t + 1);
            } else {
                wordsMap.put(word, 1);
                hitCounts.put(word, 0);
            }
        }
        for(int i = 0; i < M; i++) {
            find(i, s, results);
        }
        return results;
    }

    private void find(int start, String s, List<Integer> results) {
        if ((sLen - start) < N * M) {
            return;
        }
        int i = start;
        int count = 0;
        while ((sLen - i) >= M) {
            String str = getSubStr(i, s);
            if (hitCounts.containsKey(str)) {
                if (hitCounts.get(str) == wordsMap.get(str)) {
                    while (!hit.isEmpty()) {
                        String tmp = popStr();
                        count--;
                        if (tmp.equals(str)) {
                            break;
                        }
                    }
                }
                hitCounts.put(str, hitCounts.get(str) + 1);
                hit.add(str);
                count++;
            } else {
                while (!hit.isEmpty()) {
                    popStr();
                }
                count = 0;
            }
            if (count == N) {
                results.add(i - (N - 1) * M);
                popStr();
                count--;
            }
            i += M;
        }
        for (String str : hitCounts.keySet()) {
            hitCounts.put(str, 0);
        }
        hit = new LinkedList<>();
    }

    private String popStr() {
        String tmp = hit.pop();
        hitCounts.put(tmp, hitCounts.get(tmp) - 1);
        return tmp;
    }

    private String getSubStr(int start, String s) {
        return s.substring(start, start + M);
    }

    public static void main(String[] args) {
        FindSubstring30 fs = new FindSubstring30();
//        String s = "bfofofbfofoffoothefoobarfooman";
//        String[] words = {"abc", "bc", "fof"};
        String s = "aaaaaaaa";
        String[] words = {"aa", "aa", "aa"};
        List<Integer> results = fs.findSubstring(s, words);
        System.out.println(results);
    }
}
