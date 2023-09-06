package isSubsequence;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）
 */
public class SolutionTwoIndex {

    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.err.println(isSubsequence(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        int length = s.length();
        int tLength = t.length();
        int sCount = 0, tCount=0;
        while (sCount < length && tCount < tLength) {
            if (s.charAt(sCount) == t.charAt(tCount)) {
                sCount++;
            }
            tCount++;
        }
        return sCount == length;
    }
}
