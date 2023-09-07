package canConstruct;

import java.util.HashMap;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
class Solution {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aan";
        System.err.println(canConstruct(ransomNote, magazine));
    }

    /**
     * 使用hashmap存放数据 时间为：21ms 击败5%的用户
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            Integer integer = ransomMap.get(c);
            if (integer == null) {
                ransomMap.put(c, 1);
            } else {
                ransomMap.put(c, integer+=1);
            }
        }

        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            Integer integer = magazineMap.get(c);
            if (integer == null) {
                magazineMap.put(c, 1);
            } else
                magazineMap.put(c, integer+=1);
        }
        for (Character character : ransomMap.keySet()) {
            Integer oldCount = ransomMap.get(character);
            Integer compareCount = magazineMap.get(character);
            if (compareCount == null || compareCount < oldCount) {
                return false;
            }
        }
        return true;
    }
}
