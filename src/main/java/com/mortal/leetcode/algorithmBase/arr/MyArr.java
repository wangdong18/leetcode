package algorithmBase.arr;

/**
 * 我的数组
 */
public class MyArr {
    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3
        };
        int[] ints = addMid(nums, 2, 4);
        for (int anInt : ints) {
            System.err.println(anInt);
        }
        int[] deleteMid = deleteMid(ints, 3);
        for (int anInt : deleteMid) {
            System.err.println(anInt);
        }
    }

    /**
     * 在中间插入元素
     *
     * @param nums
     * @param index
     * @param value
     */
    public static int[] addMid(int[] nums, int index, int value) {
        int[] result = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = result.length-1; i > index; i--) {
            result[i] = result[i - 1];
        }
        result[index] = value;
        return result;
    }

    /**
     * 在中间删除元素
     *
     * @param nums
     * @param index
     */
    public static int[] deleteMid(int[] nums, int index) {
        int[] result = new int[nums.length-1];
        for (int i = index; i<nums.length-1; index++) {
            nums[index] = nums[index + 1];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i];
        }
        return result;
    }
}
