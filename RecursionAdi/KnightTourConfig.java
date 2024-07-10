package RecursionAdi;

import java.util.Arrays;

public class KnightTourConfig {
    public static void main(String[] args) {
        int[][] board = {
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };

//        int[][] board = {
//                {0,3,6},
//                {5,8,1},
//                {2,7,4}
//        };

        System.out.println(solve(board, 0, 0, 0));
    }

    static boolean solve(int[][] board, int row, int col, int step) {
        int n = board.length;
        if(step == n * n - 1) {
            return true;
        }

        int[] nextMove = next(board, row, col, step + 1);

        if(nextMove[0] != -1 && nextMove[1] != -1) {
            return solve(board, nextMove[0], nextMove[1], step + 1);
        }

        return false;
    }

    static int[] next(int[][] board, int row, int col, int step) {
        int[] move = {-1, -1};
        int n = board.length;

        int upRow = row - 2;
        int upLeft = col - 1;
        if(upRow >= 0 && upLeft >= 0) {
            if(board[upRow][upLeft] == step) {
                return new int[]{upRow, upLeft};
            }
        }

        int upRight = col + 1;
        if(upRow >= 0 && upRight < n) {
            if(board[upRow][upRight] == step) {
                return new int[]{upRow, upRight};
            }
        }

        int downRow = row + 2;
        int downLeft = col - 1;
        if(downRow < n && downLeft >= 0) {
            if(board[downRow][downLeft] == step) {
                return new int[]{downRow, downLeft};
            }
        }

        int downRight = col + 1;
        if(downRow < n && downRight < n) {
            if(board[downRow][downRight] == step) {
                return new int[]{downRow, downRight};
            }
        }

        int horizontalUp = row - 1;
        int leftUpCol = col - 2;
        if(horizontalUp >= 0 && leftUpCol >= 0) {
            if(board[horizontalUp][leftUpCol] == step) {
                return new int[]{horizontalUp, leftUpCol};
            }
        }

        int rightUpCol = col + 2;
        if(horizontalUp >= 0 && rightUpCol < n) {
            if(board[horizontalUp][rightUpCol] == step) {
                return new int[]{horizontalUp, rightUpCol};
            }
        }

        int horizontalDown = row + 1;
        int leftDown = col - 2;
        if(horizontalDown < n && leftDown >= 0) {
            if(board[horizontalDown][leftDown] == step) {
                return new int[]{horizontalDown, leftDown};
            }
        }

        int rightDown = col + 2;
        if(horizontalDown < n && rightDown < n) {
            if(board[horizontalDown][rightDown] == step) {
                return new int[]{horizontalDown, rightDown};
            }
        }

        return move;
    }
}
