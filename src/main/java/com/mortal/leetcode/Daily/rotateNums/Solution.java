package rotateNums;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6, 7
        };
        rotate(nums, 1);
    }


    public static void rotate(int[] nums, int k) {
//        k %= nums.length;
//        int[] temp = new int[nums.length];
//        for (int i = 0; i < temp.length; i++) {
//            temp[i] = nums[i];
//        }
//        for (int i = 0; i < nums.length; ++i) {
//            nums[i] = temp[(nums.length-k + i) % nums.length];
//        }

        //i元素的下标变成（i+k）/mod n 的位置
        k %= nums.length;
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; ++i) {
            temp[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        for (int num : nums) {
            System.err.print(num);
        }
    }
    //循环变换位置不行 超出时间限制
//    public static void rotate(int[] nums, int k) {
//        int length = nums.length;
//        while (k > 0) {
//            int num = nums[length - 1];
//            for (int i = length - 1; i > 0; i--) {
//                nums[i] = nums[i - 1];
//            }
//            nums[0] = num;
//            k--;
//        }
//    }
}
