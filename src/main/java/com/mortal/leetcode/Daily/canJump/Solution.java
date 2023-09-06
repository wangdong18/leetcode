package canJump;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{
                2,3,1,1,4
        };
        boolean b = canJump(nums);
        System.err.println(b);
    }
    //从后往前遍历,设置最后的位置tar，如果能够到达这个位置，那么将这个位置给tar
    //最后看下是不是能够到最开始的0位置
    public static boolean canJump(int[] nums) {
        int lastIndex = nums.length-1;
        for (int i = nums.length - 2; i >=0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}
