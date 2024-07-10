package Recursions;

public class ReverseDigit {
    public static void main(String[] args) {
        reverse1(12345);
        System.out.println(rev);
    }

    static int rev;
    static void reverse1(int n){
        if (n == 0)
            return;

        int rem = n % 10;
        rev = (rev * 10) + rem;

        reverse1(n / 10);
    }

}
