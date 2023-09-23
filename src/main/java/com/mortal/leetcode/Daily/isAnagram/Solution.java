package isAnagram;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * @auther mortal
 * @date 2023/9/23 15:16
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aaca";
        String t = "acca";
        System.err.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if( s.length() != t.length()){
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char tc = t.charAt(i);
            int i1 = c - 97;
            int i2 = tc- 97;
            nums[i1] ++;
            nums[i2] --;
        }
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
