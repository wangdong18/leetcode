package isomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
class Solution {
    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<Character, Character>();
        Map<Character, Character> tMap = new HashMap<Character, Character>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((smap.containsKey(x) && smap.get(x) != y)
                    || (tMap.containsKey(y) && tMap.get(y) != x)) {
                return false;
            }
            smap.put(x, y);
            tMap.put(y, x);
        }
        return true;
    }
}
