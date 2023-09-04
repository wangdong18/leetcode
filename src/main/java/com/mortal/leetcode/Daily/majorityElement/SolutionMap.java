package majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class SolutionMap {
    public static void main(String[] args) {
        int[] nums = new int[]{
                3,2,3
        };
        System.err.println(majorityElement(nums));
    }

    /**
     * 值塞入map 比较map 中值最大的那个
     *
     * @param nums
     * @return
     */
    private static HashMap<Integer, Integer> toMap(int[] nums) {
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            Integer value = resultMap.get(num);
            if (value != null) {
                value++;
                resultMap.put(num, value);
            } else {
                resultMap.put(num, 1);
            }
        }
        return resultMap;
    }

    public static  int majorityElement(int[] nums) {
        Map<Integer, Integer> integerIntegerHashMap = toMap(nums);

        Map.Entry<Integer, Integer> result = null;
        for (Map.Entry<Integer, Integer> entry   : integerIntegerHashMap.entrySet()) {
            if (result == null || entry.getValue() > result.getValue()) {
                result = entry;
            }
        }
        return result.getKey();
    }

}
