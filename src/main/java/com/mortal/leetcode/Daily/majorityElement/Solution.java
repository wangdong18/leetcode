package majorityElement;

import java.util.Arrays;

/**
 *给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{
                6,6,6,7,7
        };
        System.err.println(majorityElement(nums));
    }
    //使用排序找出里面中间的数字
    //直接除以2得到的就是中间位置的索引
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length / 2;
        return nums[length];
    }

}
