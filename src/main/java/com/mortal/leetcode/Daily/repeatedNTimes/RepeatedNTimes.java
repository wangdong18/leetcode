package com.mortal.leetcode.Daily.repeatedNTimes;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个整数数组 nums ，该数组具有以下属性：
 *
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array
 *
 * @Author: mortal
 * @Date: 2022/5/21 13:35
 *
 * 时间复杂度 O(1)
 * 空间复杂度 O(n) set
 */
public class RepeatedNTimes {
    public static void main(String[] args) {

    }

    public  static int repeatedNTimes(int[] nums){
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }
}
