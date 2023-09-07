package canConstruct;

import java.util.HashMap;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
class SolutionArrary {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aan";
        System.err.println(canConstruct(ransomNote, magazine));
    }


    /**
     * 使用26位的数组保存对应的字母的次数
     * 将大的塞进数组 每个字母对应一个数字
     * 将小的在数组中比较，如果没有或者小于0的就不行了
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] ransom = new int[26];
        int temp;
        for (char c : magazine.toCharArray()) {
            temp = c - 'a';
            ransom[temp]++;
        }
        for (char c : ransomNote.toCharArray()) {
            temp = c - 'a';
            ransom[temp]--;
            if (ransom[temp] < 0) {
                return false;
            }
        }
        return true;
    }
}
