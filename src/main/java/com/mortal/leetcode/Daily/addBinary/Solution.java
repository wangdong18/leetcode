package addBinary;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * @auther mortal
 * @date 2023/10/2 21:44
 */
public class Solution {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a, b);
        String s1 = Integer.toBinaryString(256);
        System.err.println(s1);
        System.err.println(s);
    }

    /**
     * 超过最大长度
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
}
