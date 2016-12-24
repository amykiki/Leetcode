import java.util.*;

/**
 * Created by zoushumin on 2016/12/12.
 */
public class WordSearch79 {
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
                if (find(calcIndex(i, j), 0, usedChars)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(int idx, int wordIdx, Set<Integer> usedChars) {
        int indexX = idx / maxY;
        int indexY = idx % maxY;

        if (charBoard[indexX][indexY] != words[wordIdx]) {
            return false;
        } else if (wordIdx == words.length - 1) {
            return true;
        }
        /*Set<Integer> failedChars = new HashSet<>();
        if (wordsFailed.get(wordIdx) != null && wordsFailed.get(wordIdx).get(idx) != null) {
            failedChars = wordsFailed.get(wordIdx).get(idx);
        }*/
        List<Integer> nextIdxes = nextIdxes(idx, usedChars);
        if (nextIdxes != null) {
            usedChars.add(idx);
            for (int nextI : nextIdxes) {
                if (find(nextI, wordIdx + 1, usedChars)) {
                    return true;
                }
            }
            /*Map<Integer, Set<Integer>> map;
            if (wordsFailed.get(wordIdx) == null) {
                map = new HashMap<>();
                wordsFailed.put(wordIdx, map);
            } else {
                map = wordsFailed.get(wordIdx);
            }
            map.put(idx, failedChars);*/
        }
        usedChars.remove(idx);
        return false;
    }

    private List<Integer> nextIdxes(int index, Set<Integer> usedChars) {
        List<Integer> indexes = new ArrayList<>();
        int upIndex = index - maxY;
        int downIndex = index + maxY;
        int leftIndex = index - 1;
        int rightIndex = index + 1;

        int indexX = index / maxY;
        int indexY = index % maxY;
        if (indexX > 0 && !usedChars.contains(upIndex)) {
            indexes.add(upIndex);
        }
        if (indexX < (maxX - 1) && !usedChars.contains(downIndex)) {
            indexes.add(downIndex);
        }
        if (indexY > 0 && !usedChars.contains(leftIndex)) {
            indexes.add(leftIndex);
        }

        if (indexY < (maxY - 1) && !usedChars.contains(rightIndex)) {
            indexes.add(rightIndex);
        }
        return indexes.isEmpty() ? null : indexes;
    }



    private int calcIndex(int x, int y) {
        return x*maxY + y;
    }


    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "CFDE";
//        String word = "ABCCED";
//        String word = "SEE";
//        String word = "ABCB";


        char[][] board = {"ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray()};
        String word = "ABCESEEEFS";
        WordSearch79 ws = new WordSearch79();
        System.out.println(ws.exist(board, word));
    }
}
