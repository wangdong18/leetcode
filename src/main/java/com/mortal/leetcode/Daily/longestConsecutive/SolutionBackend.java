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
public class SolutionBackend {

    public static void main(String[] args) {
        int[] nums = new int[]{
                9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6
        };
        int i = longestConsecutive(nums);
        System.err.println(i);

    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int lastIndex = 0;
        int startIndex = 0;
        int tempStartIndex = 0;
        int tempEndIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                ++tempEndIndex;
            } else {
                if (tempEndIndex - tempStartIndex > lastIndex - startIndex) {
                    lastIndex = tempEndIndex;
                    startIndex = tempStartIndex;
                }
                tempStartIndex = i;
                tempEndIndex = i;
            }
        }
        if (tempEndIndex - tempStartIndex > lastIndex - startIndex) {
            lastIndex = tempEndIndex;
            startIndex = tempStartIndex;
        }
        return lastIndex - startIndex + 1;
    }

}
