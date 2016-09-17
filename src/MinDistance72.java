/**
 * Created by Amysue on 2016/9/17.
 */
public class MinDistance72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int col = 1 + word1.length();
        int row = 1 + word2.length();
        int[][] distances = new int[row][col];
        for(int i = 0; i < col; i++) {
            distances[0][i] = i;
        }
        for(int i = 0; i < row; i++) {
            distances[i][0] = i;
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                char c1 = word1.charAt(j - 1);
                char c2 = word2.charAt(i - 1);
                int d1 = Math.min(distances[i][j - 1] + 1, distances[i - 1][j] + 1); // min distance for add or remove.distances[i][j-1] means romove, distances[i-1][j] means add
                int replace = distances[i - 1][j - 1] + (c1 == c2 ? 0 : 1);
                int distance = Math.min(d1, replace);
                distances[i][j] = distance;
            }
        }
        return distances[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MinDistance72 md = new MinDistance72();
        String word1 = "ready";
        String word2 = "update";
        int distance = md.minDistance(word1, word2);
        System.out.println("distance = " + distance);
    }
}
