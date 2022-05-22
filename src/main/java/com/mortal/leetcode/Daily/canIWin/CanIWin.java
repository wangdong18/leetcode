package com.mortal.leetcode.Daily.canIWin;

import java.util.HashMap;
import java.util.Map;

/**
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 * <p>
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 * <p>
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * <p>
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。
 * 假设两位玩家游戏时都表现 最佳 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/can-i-win
 *
 * @Author: mortal
 * @Date: 2022/5/22 20:29
 */
public class CanIWin {

    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        canIWin.canIWin(10,30);
    }
    public  boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //总长度不满足目标值
        if (maxChoosableInteger * (maxChoosableInteger + 1) < (desiredTotal * 2)) {
            return false;
        }
        //存储state的变量值，state一共有2^maxChoosableInteger种
        Map<Integer, Boolean> memory = new HashMap<Integer, Boolean>(1 << maxChoosableInteger);
        //开始遍历整个树
        return dfs(maxChoosableInteger, 0, desiredTotal, 0, memory);
    }

    /**
     * @param maxChoosableInteger 最大可选择的数字
     * @param state               状态位
     * @param desiredTotal        目标值
     * @param curTotal            当前值
     * @param memory              存储搜索过的状态
     * @return
     */
    private boolean dfs(int maxChoosableInteger, int state, int desiredTotal, int curTotal, Map<Integer, Boolean> memory) {
        System.err.println("状态位置为"+state);
        System.err.println("目标值"+desiredTotal);
        System.err.println("当前值"+curTotal);
        System.err.println("存储搜索过的状态"+memory);
        System.err.println("-------------------------------------------");
        if (!memory.containsKey(state)) {
            boolean ans = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                //state的第i位表示 第i+1个数字被使用
                if (((state >> i) & 1) == 1) {
                    continue;
                }
                //先手取i看 能不能赢 不能赢则轮到对手取数字
                if (curTotal + i + 1 >= desiredTotal) {
                    ans = true;
                    break;
                }
                //轮到对手取数字 若对手不能赢（必然输掉的状态） 则我方赢
                //state | (1 << i), 将state的第i位置为已使用
                if (!dfs(maxChoosableInteger, state | (1 << i), desiredTotal, curTotal + i + 1, memory)) {
                    ans = true;
                    break;
                }
            }
            memory.put(state, ans);
        }
        return memory.get(state);
    }
}
