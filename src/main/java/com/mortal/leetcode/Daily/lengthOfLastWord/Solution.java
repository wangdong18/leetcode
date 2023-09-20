package lengthOfLastWord;

/**
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @auther mortal
 * @date 2023/9/20 22:34
 */
public class Solution {

    public static void main(String[] args) {
        String s = "Hello World";
        System.err.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        int length = s.length() - 1;
        for (int i = length; i>0; i--) {
            if (String.valueOf(s.charAt(i)).equals(" ")) {
                return length-i;
            }
        }
        return s.length();
    }
}
