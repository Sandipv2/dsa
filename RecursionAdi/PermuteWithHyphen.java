package RecursionAdi;

public class PermuteWithHyphen {
    public static void main(String[] args) {
        String str = "abc";

        str = str.substring(1);

        permute(0, str, "a");
    }

    static void permute(int i, String str, String combi) {
        if(i == str.length()) {
            System.out.println(combi);
            return;
        }

        String withHypen = combi + "-" + str.charAt(i);
        String wihtoutHypen = combi + str.charAt(i);

        permute(i+1, str, withHypen);
        permute(i+1, str, wihtoutHypen);
    }
}
