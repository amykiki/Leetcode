import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amysue on 2016/8/9.
 */
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows   = new Set[9];
        Set<Character>[] cols   = new Set[9];
        Set<Character>[] blocks = new Set[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rows[i] == null) {
                        rows[i] = new HashSet<>();
                    }
                    if (!rows[i].add(board[i][j])) {
                        return false;
                    }
                    if (cols[j] == null) {
                        cols[j] = new HashSet<>();
                    }
                    if (!cols[j].add(board[i][j])) {
                        return false;
                    }
                    int m = (i / 3) * 3 + j / 3;
                    if (blocks[m] == null) {
                        blocks[m] = new HashSet<>();
                    }
                    if (!blocks[m].add(board[i][j])) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
