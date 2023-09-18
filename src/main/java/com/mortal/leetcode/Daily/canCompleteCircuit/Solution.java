package canCompleteCircuit;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 *
 * @auther mortal
 * @date 2023/9/18 14:31
 */
public class Solution {

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int i = canCompleteCircuit(gas, cost);
        System.err.println(i);
    }


    /**
     * 贪心算法
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int temp = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            int thisTurn = gas[i] - cost[i];
            temp = temp + thisTurn;
            if (temp < min) {
                min = temp;
                result = i + 1;
            }
        }
        return result > 0 ? result : -1;
    }

}
