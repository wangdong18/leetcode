package deleteElement;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次
 * ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 1, 1, 2, 3
        };
        int i = removeDuplicates(nums);
        System.err.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i + 1];
                index++;
            }
        }
        return index;
    }
}
