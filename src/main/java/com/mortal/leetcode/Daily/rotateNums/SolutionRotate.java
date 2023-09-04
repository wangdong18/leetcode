package rotateNums;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class SolutionRotate {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6, 7
        };
        rotate(nums, 1);
    }


    //使用数组翻转
    //只有三次 不会比你的每一次都转换耗时长
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        rotateNums(nums, 0, length - 1);
        rotateNums(nums, k, length - 1);
        rotateNums(nums, 0, k - 1);
    }

    public static void rotateNums(int[] nums, int start,int end) {
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
