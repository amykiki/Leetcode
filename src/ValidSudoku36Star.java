/**
 * Created by Amysue on 2016/8/10.
 */
public class ValidSudoku36Star {
    /*
    * 非常巧妙的算法，用了位运算操作来代替hash，这是别人网上的做法，标记为star，予以参考
    * https://discuss.leetcode.com/topic/40078/yet-another-java-2ms-solution/2*/
    public boolean isValidSudoku(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }
}
