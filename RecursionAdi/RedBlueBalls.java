package RecursionAdi;

public class RedBlueBalls {
    // Bugs !! Need fixes;
    public static void main(String[] args) {
        int r = 10;
        int b = 1;
        int h1 = solve(r, b, 1, 0);
        int h2 = solve(b, r, 1, 0);
        System.out.println(h1+" "+h2);
    }

    static int solve(int red, int blue, int row, int h) {
        if(row <= red) {
            return solve(red-row, blue, row+2, h+1);
        }

        if(row <= blue) {
            return solve(red, blue-row, row+2, h+1);
        }

        return h;
    }
}
