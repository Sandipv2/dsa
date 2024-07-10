package Recursions;

public class Pattern2 {
    public static void main(String[] args) {
        pattern(5,5);
    }

    static void pattern(int n,int m){
        if(n < 1)
            return;

        for (int i=n; i<=m; i++)
            System.out.print("*");

        System.out.println();

        pattern(n-1, m);
    }
}
