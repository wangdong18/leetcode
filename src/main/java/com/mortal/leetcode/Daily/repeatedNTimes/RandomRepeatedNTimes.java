package com.mortal.leetcode.Daily.repeatedNTimes;

import java.util.Random;

/**
 * 采用随机算法
 * 听天由命
 *    时间复杂度 O(1)=n/2n *n-1/2n ≈ 1/4
 *    空间复杂度 O(1)
 * @Author: mortal
 * @Date: 2022/5/21 13:57
 */
public class RandomRepeatedNTimes {

    public  static int repeatedNTimes(int[] nums){
        Random random = new Random();
        int n = nums.length;
        while (true){
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }
}
