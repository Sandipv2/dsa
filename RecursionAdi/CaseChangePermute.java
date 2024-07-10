package RecursionAdi;

public class CaseChangePermute {
    public static void main(String[] args) {
        permute(0, "ab", "");
    }

    static void permute(int i, String str, String set) {
        if(i == str.length()) {
            System.out.println(set);
            return;
        }

        String upper = set + String.valueOf(str.charAt(i)).toUpperCase();
        String lower = set + str.charAt(i);

        permute(i+1, str, upper);
        permute(i+1, str, lower);
    }
}
