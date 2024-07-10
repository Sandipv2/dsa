package RecursionAdi;

public class PermuteStringInNum {
    public static void main(String[] args) {
        String str = "a1b2";
        permute(0, str, "");
    }

    private static void permute(int i, String str, String set) {
        if(i == str.length()) {
            System.out.println(set);
            return;
        }

        char ch = str.charAt(i);

        if(Character.isDigit(ch)) {
            set += ch;
            permute(i+1, str, set);
        }
        else {
            String upper = set + String.valueOf(ch).toUpperCase();
            String lower = set + String.valueOf(ch).toLowerCase();
            permute(i+1, str, upper);
            permute(i+1, str, lower);
        }
    }
}
