package isSubsequence;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）
 */
public class Solution {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.err.println(isSubsequence(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (sIndex <s.length()&&c == s.charAt(sIndex)) {
                sIndex++;
            }
        }
        return sIndex == s.length();
    }
}
