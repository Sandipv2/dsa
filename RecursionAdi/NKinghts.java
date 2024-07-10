package RecursionAdi;

public class NKinghts {
    public static void main(String[] args) {
        int n = 2;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0,0,n,0);
    }

    static void solve(char[][] board, int row, int col, int n, int placed) {
        if(placed == n) {
            print(board);
            System.out.println();
            return;
        }

        if (row == n) return;
        if(col == n) {
            solve(board, row+1, 0, n, placed);
            return;
        }

        if(isValid(board, row, col)) {
            board[row][col] = 'K';
            solve(board, row, col+1, n, placed+1);
            board[row][col] = '.';
        }

        solve(board, row, col+1, n, placed);
    }

    private static boolean isValid(char[][] board, int row, int col) {

        int n = board.length;
        if(row >= n || row < 0 || col >= n || col < 0) return false;

        int upRow = (row - 2);
        int upRightCol = col + 1;
        if(upRow >= 0 && upRightCol < n) {
            if(board[upRow][upRightCol] == 'K') {
                return false;
            }
        }

        int upLeftCol = col - 1;
        if(upRow >= 0 && upLeftCol >= 0) {
            if(board[upRow][upLeftCol] == 'K') {
                return false;
            }
        }

        int rightUpCol = (col + 2);
        int leftRightRow = row - 1;

        if(leftRightRow >= 0 && rightUpCol < n) {
            if(board[leftRightRow][rightUpCol] == 'K') {
                return false;
            }
        }

        int leftUpCol = col - 2;

        if(leftRightRow >= 0 && leftUpCol >= 0) {
            if(board[leftRightRow][leftUpCol] == 'K') {
                return false;
            }
        }

        return true;
    }

    static void print(char[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
