package RecursionAdi;

public class GenerateBalancedParentheses {
    static void generate(int open, int close, String str) {
        if (open == 0 && close == 0) {
            System.out.println(str);
            return;
        }

        if(open != 0) {
            generate(open-1, close, str + "(");
        }

        if(close > open){
            generate(open, close - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generate(n,n,"");
    }
}
