package com.mortal.leetcode.start;

/**
 * @author mortal
 * @create 2022/1/14 10:30
 */
public class LongestPalindrome {
    //    给你一个字符串 s，找到 s 中最长的回文子串。
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String result = "";
        String lastResult = "";
        for (int i = 0; i < chars.length; i++) {
            result = String.valueOf(chars[i]);
            String temp = s.substring(i+1,chars.length);
            int j = i+1;
            while (temp.contains(result)){
                temp = s.substring(j,chars.length);
                result =result+s.substring(j,j+1);
                j++;
            }
            if(j<s.length()&&result.startsWith(s.substring(j,j+1))){
                result =result+s.substring(j,j+1);
            }
            if(lastResult.length()<result.length()){
                lastResult = result;
            }
        }
        return lastResult;
    }

    public static void main(String[] args) {
        String s = "aaaaaa";
        System.err.println(longestPalindrome(s));
    }
}
