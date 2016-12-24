import java.util.*;

/**
 * Created by zoushumin on 2016/12/12.
 */
public class WordSearch79 {
    private char[] words;
    private int maxY, maxX;
    private Map<Character, Set<Integer>> cmaps = new HashMap<>();
    public boolean exist(char[][] board, String word) {
        if (word == null || board == null || board[0] == null) {
            return false;
        }
        maxX = board.length - 1;
        maxY = board[0].length - 1;
        words = word.toCharArray();
        Map<Character, Integer> wmap = new HashMap<>();
        for (char c : words) {
            if (wmap.containsKey(c)) {
                wmap.put(c, wmap.get(c) + 1);
            } else {
                wmap.put(c, 1);
            }
        }
        for (int i = 0; i <= maxX; i++) {
            for(int j = 0; j <= maxY; j++) {
                Character c = board[i][j];
                if (wmap.containsKey(c)) {
                    if (cmaps.containsKey(c)) {
                        cmaps.get(c).add(calcIndex(i, j));
                    } else {
                        Set<Integer> set = new HashSet<>();
                        set.add(calcIndex(i, j));
                        cmaps.put(c, set);
                    }
                }

            }
        }
        for (Character key : wmap.keySet()) {
            if (!cmaps.containsKey(key) || cmaps.get(key).size() < wmap.get(key)) {
                return false;
            }
        }

        return find(0, new LinkedList<Integer>(), new HashSet<Integer>());
    }

    private int calcIndex(int x, int y) {
        return x*(maxY + 1) + y;
    }

    private boolean find(int wordIndex, LinkedList<Integer> lastList, Set<Integer> usedSet) {
        char c = words[wordIndex];
        if (!cmaps.containsKey(words[wordIndex])) {
            return false;
        }
        Set<Integer> nexts = nextIndxes(lastList.peekLast(), usedSet);
        if (!lastList.isEmpty() && nexts == null) {
            return false;
        }
        for (int i : cmaps.get(c)) {
            if (usedSet.contains(i)) {
                continue;
            }
            if (nexts != null && !nexts.contains(i)) {
                continue;
            }
            if (wordIndex == words.length - 1) {
                return true;
            }
            lastList.addLast(i);
            usedSet.add(i);
            if (find(wordIndex + 1, lastList, usedSet)) {
                return true;
            }
            lastList.pollLast();
            usedSet.remove(i);
        }
        return false;
    }
    private Set<Integer> nextIndxes(Integer index, Set<Integer> usedSet) {
        if (index == null) {
            return null;
        }
        Set<Integer> indexes = new HashSet<>();
        int ylen = maxY + 1;
        int upIndex = index - ylen;
        int downIndex = index + ylen;
        int leftIndex = index - 1;
        int rightIndex = index + 1;

        int indexX = index / ylen;
        int indexY = index % ylen;
        if (indexX > 0 && !usedSet.contains(upIndex)) {
            indexes.add(upIndex);
        }
        if (indexX < maxX && !usedSet.contains(downIndex)) {
            indexes.add(downIndex);
        }
        if (indexY > 0 && !usedSet.contains(leftIndex)) {
            indexes.add(leftIndex);
        }

        if (indexY < maxY && !usedSet.contains(rightIndex)) {
            indexes.add(rightIndex);
        }
        return indexes.isEmpty() ? null : indexes;
    }
    /*public boolean exist(char[][] board, String word) {
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
        *//*Set<Integer> failedChars = new HashSet<>();
        if (wordsFailed.get(wordIdx) != null && wordsFailed.get(wordIdx).get(idx) != null) {
            failedChars = wordsFailed.get(wordIdx).get(idx);
        }*//*
        List<Integer> nextIndxes = nextIndxes(idx, usedChars);
        if (nextIndxes != null) {
            usedChars.add(idx);
            for (int nextI : nextIndxes) {
                if (find(nextI, wordIdx + 1, usedChars)) {
                    return true;
                }
            }
            *//*Map<Integer, Set<Integer>> map;
            if (wordsFailed.get(wordIdx) == null) {
                map = new HashMap<>();
                wordsFailed.put(wordIdx, map);
            } else {
                map = wordsFailed.get(wordIdx);
            }
            map.put(idx, failedChars);*//*
        }
        usedChars.remove(idx);
        return false;
    }

    private List<Integer> nextIndxes(int index, Set<Integer> usedChars) {
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
    }*/


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "CFDE";
//        String word = "ABCCED";
//        String word = "SEE";
        String word = "ABCB";


//        char[][] board = {"ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray()};
//        String word = "ABCESEEEFS";
        WordSearch79 ws = new WordSearch79();
        System.out.println(ws.exist(board, word));
    }
}
