package wordpatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */

public class Solution {

    public static void main(String[] args) {
        String pattern = "aaa";
        String s = "aa aa aa aa";
        boolean b = wordPattern(pattern, s);
        System.err.println(b);
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMap = new HashMap<Character, String>();
        Map<String, Character> sMap = new HashMap<String, Character>();
        String[] s1 = s.split(" ");
        if (s1.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            char c = pattern.charAt(i);
            if ((patternMap.get(c) != null && !patternMap.get(c).equals(s2))
                    || (sMap.get(s2) != null && !sMap.get(s2).equals(c))) {
                return false;
            }
            patternMap.put(c, s2);
            sMap.put(s2, c);
        }
        return true;
    }
}
