/**
 * Created by Amysue on 2016/8/10.
 */
public class SolveSudoku37 {
    public void solveSudoku(char[][] board) {
        int     LEN    = 9;
        int[]   rows   = new int[LEN];
        int[]   cols   = new int[LEN];
        int[]   blocks = new int[LEN];
        int[][] values = new int[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    int m = 1 << n;
                    rows[i] |= m;
                    cols[j] |= m;
                    int k = (i / 3) * 3 + j / 3;
                    blocks[k] |= m;
                    values[i][j] = -1;
                }
            }
        }
        int     j   = 0;
        boolean back = false;
        int i = 0;
        while (i >= 0 && i < LEN) {
            while (j >= 0 && j < LEN) {
                if (board[i][j] == '.') {
                    int value = ~(rows[i] | cols[j] | blocks[getBlock(i, j)]);
                    value &= 0x3fe;
                    if (value > 0) {
                        values[i][j] = value;
                        int next = add(rows, cols, blocks, values, i, j);
                        board[i][j] = (char) (next + '0');
                        j++;
                        back = false;
                    } else {
                        j--;
                        back = true;
                    }

                } else {
                    if (back) {
                        if (values[i][j] >= 0) {
                            int m = board[i][j] - '0';
                            substract(rows, cols, blocks, i, j, m);
                            if (values[i][j] == 0) {
                                board[i][j] = '.';
                                j--;
                            } else {
                                int next = add(rows, cols, blocks, values, i, j);
                                board[i][j] = (char) (next + '0');
                                j++;
                                back = false;
                            }
                        } else {
                            j--;
                        }
                    } else {
                        j++;
                    }
                }
            }
            if (j == LEN) {
                i++;
                j = 0;
            } else {
                i--;
                j = LEN - 1;
            }
        }
    }

    private int add(int[] rows, int[] cols, int[] blocks, int[][] values, int i, int j) {
        int next = getBoard(i, j, values);
        int m    = 1 << next;
        rows[i] |= m;
        cols[j] |= m;
        blocks[getBlock(i, j)] |= m;
        return next;
    }

    private void substract(int[] rows, int[] cols, int[] blocks, int i, int j, int n) {
        int m = 1 << n;
        rows[i] &= ~m;
        cols[j] &= ~m;
        blocks[getBlock(i, j)] &= ~m;
        return;
    }

    private int getBoard(int i, int j, int[][] values) {
        int value = values[i][j];
        int n     = value & ~(value - 1);
        values[i][j] = value - n;
        int count = 0;
        while (n > 1) {
            count += 1;
            n = n >> 1;
        }
        return count;
    }

    private int getBlock(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                String str = "";
                if (board[i][j] == '.') {
                    System.out.print("   |");
                } else {
                    str = String.format("% 2d", board[i][j] - '0');
                    System.out.print(str);
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SolveSudoku37 ss = new SolveSudoku37();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        ss.printBoard(board);
        ss.solveSudoku(board);

    }
}
