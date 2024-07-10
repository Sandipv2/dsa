package RecursionAdi;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, n, 0);
    }

    static void solve(char[][] board, int n, int row) {
        if(row == n) {
            print(board);
            System.out.println();
            return;
        }

        for(int j = 0; j < n; j++) {
            if(isValid(board, row, j)) {
                board[row][j] = 'Q';
                solve(board, n, row + 1);
                board[row][j] = '.'; // backtrack;
            }
        }
    }

    static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        for(int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') return false;
        }

        int i = row;
        int j = col;
        while(i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') return false;
        }

        i = row;
        j = col;
        while(i >= 0 && j < n) {
            if (board[i--][j++] == 'Q') return false;
        }

        return true;
    }

    static void print(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}