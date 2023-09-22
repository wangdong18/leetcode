package reverseWords;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * @auther mortal
 * @date 2023/9/22 21:34
 */
public class SolutionQueue {


    public static void main(String[] args) {
        String a = "  hello world  ";
        System.err.println(reverseWords(a));
    }
    public static  String reverseWords(String s) {
        int left=0;
        int right = s.length() - 1;
        //去掉左边的空格
        while ((left <= right) && s.charAt(left)==' ') {
            ++left;
        }
        while (left <= right && s.charAt(right)==' ') {
            --right;
        }

        Deque<String> deque = new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer();
        while (left <= right) {
            char c = s.charAt(left);
            if (buffer.length() != 0 && c == ' ') {
                deque.offerFirst(buffer.toString());
                buffer.setLength(0);
            } else if (c != ' ') {
                buffer.append(c);
            }
            ++left;
        }
        deque.offerFirst(buffer.toString());
        return String.join(" ", deque);
    }
}
