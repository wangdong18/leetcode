package canJump;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class SolutionGreedy {
    public static void main(String[] args) {
        int[] nums = new int[]{
              0,2,3
        };
        boolean b = canJump(nums);
        System.err.println(b);
    }

    //使用贪心算法，记录当前能够到达的最大位置
    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < length-1; i++) {
            //如果上一个位置比我当前位置要小 我是不能直接改变这个值的 eg:[0,2,3]
            //这种情况下比较最大值是直接不行的，当我的最大位置能够够到当前位置，咱们才能进行替换，否则就是耍流氓
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
            if (maxIndex >= length - 1) {
                return true;
            }
        }
        return false;
    }
}
