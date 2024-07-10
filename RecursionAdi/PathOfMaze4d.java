package RecursionAdi;

public class PathOfMaze4d {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        boolean[][] map = new boolean[3][3];

        solve(0,0,row-1, col-1, map, "");
    }

    static void solve(int srow, int scol, int erow, int ecol, boolean[][] map, String path) {
        if(srow > erow || scol > ecol || srow < 0 || scol < 0) return;
        if(map[srow][scol]) return;
        if(srow == erow && scol == ecol) {
            System.out.println(path);
            return;
        }

        map[srow][scol] = true;

        // Down
        solve(srow + 1, scol, erow, ecol, map, path + "D");

        // Right
        solve(srow, scol + 1, erow, ecol, map, path + "R");

        // Left
        solve(srow, scol - 1, erow, ecol, map, path + "L");

        // Up
        solve(srow - 1, scol, erow, ecol, map, path + "U");

        map[srow][scol] = false;
    }
}
