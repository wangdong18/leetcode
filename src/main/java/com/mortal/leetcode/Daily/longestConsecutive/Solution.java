package longestConsecutive;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @auther mortal
 * @date 2023/10/4 22:54
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{
                0,3,7,2,5,8,4,6,0,1
        };
        int i = longestConsecutive(nums);
        System.err.println(i);

    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLength = 1;
        int current = 1;
        for (int i = 1; i <nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                current++;
                maxLength = Math.max(maxLength, current);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            }else {
                current = 1;
            }
        }
        return maxLength;
    }

}
