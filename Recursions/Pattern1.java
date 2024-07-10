package Recursions;

public class Pattern1 {
    public static void main(String[] args) {
        pattern(5);
    }

    static void pattern(int n){
        if(n < 1)
            return;

        for (int i=1; i<=n; i++)
            System.out.print("*");

        System.out.println();

        pattern(n-1);
    }
}
