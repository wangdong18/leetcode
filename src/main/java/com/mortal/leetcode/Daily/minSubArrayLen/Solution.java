package minSubArrayLen;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 1, 1, 1, 1, 1, 1, 1
        };
        int target = 11;
        System.err.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < length) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
