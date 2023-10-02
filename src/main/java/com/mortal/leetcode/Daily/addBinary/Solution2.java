package addBinary;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * @auther mortal
 * @date 2023/10/2 21:44
 */
public class Solution2 {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a, b);
        System.err.println(s);
    }

    public static String addBinary(String a, String b) {
        StringBuffer bf = new StringBuffer();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            bf.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            bf.append("1");
        }
        bf.reverse();
        return bf.toString();
    }
}
