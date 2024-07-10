package RecursionAdi;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        solve(board);

        for(int i = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if(j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if(i == 2 || i == 5) {
                System.out.print("- - - - - - - - - - - \n");
            }
        }
    }

    static boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char ch = '1'; ch <= '9'; ch++) {
                        if(isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if(solve(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isValid(char[][] board, int row, int col, char ch) {
        for(int i = 0; i < 9; i++) {
            // Check row
            if(board[row][i] == ch) {
                return false;
            }

            // Check col
            if(board[i][col] == ch) {
                return false;
            }

            // Grid
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            if(board[startRow + i / 3][startCol + i % 3] == ch) {
                return false;
            }
        }

        return true;
    }
}
