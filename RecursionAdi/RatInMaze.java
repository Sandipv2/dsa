package RecursionAdi;

public class RatInMaze {
    public static void main(String[] args) {
        int row = 3;
        int col = 4;
        int[][] maze = {{1,0,1,1},
                        {1,1,1,0},
                        {1,1,1,1}};

        //boolean[][] isVisited = new boolean[row][col];
        //solve(0,0,row-1, col-1, maze, "", isVisited);
        solve(0,0,row-1, col-1, maze, "");
    }

//     Optimised Space O(1);
    static void solve(int srow, int scol, int erow, int ecol, int[][] maze, String path) {
        if(srow > erow || scol > ecol || srow < 0 || scol < 0) return;
        if(maze[srow][scol] == 0) return;
        if(srow == erow && scol == ecol) {
            System.out.println(path);
            return;
        }

        maze[srow][scol] = 0;

        solve(srow + 1, scol, erow, ecol, maze, path + "D");
        solve(srow, scol + 1, erow, ecol, maze, path + "R");
        solve(srow - 1, scol, erow, ecol, maze, path + "U");
        solve(srow, scol - 1, erow, ecol, maze, path + "L");

//         Backtracing
        maze[srow][scol] = 1;
    }

//    Space complex:- O(row*col) Using extra array of map
//
//    static void solve(int srow, int scol, int erow, int ecol, int[][] maze, String path,boolean[][] isVisisted) {
//        if(srow > erow || scol > ecol || srow < 0 || scol < 0) return;
//        if(isVisisted[srow][scol]) return;
//        if(maze[srow][scol] == 0) return;
//        if(srow == erow && scol == ecol) {
//            System.out.println(path);
//            return;
//        }
//
//        isVisisted[srow][scol] = true;
//
//        solve(srow + 1, scol, erow, ecol, maze, path + "D", isVisisted);
//        solve(srow, scol + 1, erow, ecol, maze, path + "R", isVisisted);
//        solve(srow - 1, scol, erow, ecol, maze, path + "U", isVisisted);
//        solve(srow, scol - 1, erow, ecol, maze, path + "L", isVisisted);
//
//        Backtracing
//        isVisisted[srow][scol] = false;
//    }
}
