package palindrome;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class Solution {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(String s) {
        //1.去除所有的特殊字符串
        //2.反转新的字符串
        //3.比较字符串是否一致
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                char lowerCase = Character.toLowerCase(c);
                stringBuffer.append(lowerCase);
            }
        }
        String s1 = stringBuffer.toString();
        StringBuffer reverse = new StringBuffer(s1).reverse();
        return reverse.toString().equals(s1);
    }
}
