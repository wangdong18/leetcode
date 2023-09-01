/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Moslem {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(12121);
        System.err.println(palindrome);

    }
    //不使用字符串
    
    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0&&x!=0) {
            return false;
        }
        int remember = 0;
        while (x > remember) {
            remember = remember * 10 + x %10;
            x = x / 10;
        }
        return x == remember|| x== remember/10;
    }
    //使用字符串
    public static boolean usString(int x) {
        String string = String.valueOf(x);
        int  length = string.length() / 2;
            for (int i = 0; i < length; i++) {
                if (string.charAt(i) != string.charAt(string.length()-i-1)){
                    return false;
                }
            }
        return true;
    }
}
