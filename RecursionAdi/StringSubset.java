package RecursionAdi;

import java.util.ArrayList;
import java.util.List;

public class StringSubset {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        sets(0, "abc", new StringBuilder(), ans);
        System.out.println(ans);
    }

    static void sets(int idx, String str, StringBuilder sb, List<String> ans) {
        if(idx == str.length()) {
            ans.add(sb.toString());
            return;
        }

        sb.append(str.charAt(idx)); // Picked
        sets(idx + 1, str, sb, ans);

        sb.deleteCharAt(sb.length() - 1); // Not Picked
        sets(idx + 1, str, sb, ans);
    }
}
