package majorityElement;

import java.util.Arrays;
import java.util.Random;

/**
 *给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class SolutionRandom {
    public static void main(String[] args) {
        int[] nums = new int[]{
                2,2,1,1,1,2,2
        };
        System.err.println(majorityElement(nums));
    }

    public  static  int majorityElement(int[] nums) {
        Random random = new Random();
        int length = nums.length / 2;
        while (true) {
            int index = getRandom(random, 0, nums.length);
            int count = 1;
            for (int num : nums) {
                if (num == nums[index]) {
                    count++;
                }
                if (count > length) {
                    return nums[index];
                }
            }
        }
    }
    //获取在max 和min 中间的随机数
    private  static int getRandom(Random random,int min,int max) {
        return random.nextInt(max - min) + min;
    }

}
