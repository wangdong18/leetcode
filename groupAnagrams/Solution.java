package groupAnagrams;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class Solution {

    public static void main(String[] args) {
        String[] strs = new String[]{"a"};

        List<List<String>> lists = groupAnagrams(strs);
        System.err.println(lists);
    }
    public  static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String inner = strs[i];
            char[] chars = inner.toCharArray();
            Arrays.sort(chars);
            StringBuffer buffer = new StringBuffer();
            for (char aChar : chars) {
                buffer.append(aChar);
            }
            String join = buffer.toString();
            //排序修改
            List<String> strings = result.get(join);
            if (strings != null) {
                strings.add(inner);
            }else {
                strings = new ArrayList<>();
                strings.add(inner);
            }
            result.put(join, strings);
        }
        List<List<String>> lists = new ArrayList<>();
        for (List<String> value : result.values()) {
            lists.add(value);
        }
        return lists;
    }

}
