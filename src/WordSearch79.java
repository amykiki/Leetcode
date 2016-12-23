import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zoushumin on 2016/12/12.
 */
public class WordSearch79 {

    private Map<Integer, Map<Integer, Set<Integer>>> wordsFailed = new HashMap<>();
    private char[] words;
    private int maxY, maxX;
    private char[][] charBoard;
    public boolean exist(char[][] board, String word) {
        if (word == null || board == null || board[0] == null) {
            return false;
        }
        charBoard = board;
        words = word.toCharArray();
        maxX = board.length;
        maxY = board[0].length;
        for(int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                Set<Integer> usedChars = new HashSet<>();
                if (find(i, j, 0, usedChars)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(int x, int y, int wordIndex, Set<Integer> usedChars) {
        if (wordIndex == words.length) {
            return true;
        }
        if (x >= maxX || x < 0 || y >= maxY || y < 0) {
            return false;
        }
        if (usedChars.contains(calcIndex(x, y))) {
            return false;
        }
        if (charBoard[x][y] != words[wordIndex]) {
            return false;
        }
        if (wordsFailed.get(wordIndex)!= null && wordsFailed.get(wordIndex).contains(calcIndex(x, y))) {
            return false;
        }
        usedChars.add(calcIndex(x, y));
        if (find(x, y + 1, wordIndex + 1, usedChars)) {
            return true;
        }
        if (find(x, y - 1, wordIndex + 1, usedChars)) {
            return true;
        }
        if (find(x - 1, y, wordIndex + 1, usedChars)) {
            return true;
        }
        if (find(x + 1, y, wordIndex + 1, usedChars)) {
            return true;
        }
        usedChars.remove(calcIndex(x, y));
        if (wordsFailed.get(wordIndex) != null) {
            wordsFailed.get(wordIndex).add(calcIndex(x, y));
        } else {
            Set<Integer> sets = new HashSet<>();
            sets.add(calcIndex(x, y));
            wordsFailed.put(wordIndex, sets);
        }
        return false;
    }

    private int calcIndex(int x, int y) {
        return x*maxY + y;
    }

    private void addFailChar(int x, int y, int nextX, int nextY, int wordIndex) {
        Map<Integer, Set<Integer>> map;
        if (wordsFailed.get(wordIndex) != null) {
            map = wordsFailed.get(wordIndex);
        } else {
            map = new HashMap<>();
            wordsFailed.put(wordIndex, map);
        }
        int key = calcIndex(x, y);
        int value = calcIndex(nextX, nextY);
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(value);
            map.put(key, set);
        }
    }

    private void checkFailChar(int x, int y, int nextX, int nextY, int wordIndex) {

    }

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "CFDE";
//        String word = "ABCCED";
//        String word = "SEE";

        char[][] board = {"ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray()};
        String word = "ABCESEEEFS";
        WordSearch79 ws = new WordSearch79();
        System.out.println(ws.exist(board, word));
    }
}
