package com.mortal.leetcode.done;

import java.util.*;

/**
 * 219. 存在重复元素 II
 * @author mortal
 * @create 2022/1/19 10:18
 */
public class ContainsNearbyDuplicate {

    //自我套路 空间换时间
    public static  boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> integers = map.get(nums[i]);
            if(null!=integers){
                integers.add(i);
            }else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (Integer integer : map.keySet()) {
            List<Integer> integers = map.get(integer);
            for (int i = 0; i < integers.size(); i++) {
                Integer integer1 = integers.get(i);
                for (int j = integers.size()-1; j>i; j--) {
                    Integer integer2 = integers.get(j);
                    if(Math.abs(integer1-integer2)<=k){
                        return true;
                    }
                }
            }

        }
        return false;
    }


    //哈希表
    public static  boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> numberAndIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = numberAndIndexMap.get(nums[i]);
            if(null!=index&&Math.abs(i-index)<=k){
                return true;
            }
            numberAndIndexMap.put(nums[i], i);
        }
        return false;
    }

    //滑动窗口
    public static  boolean containsNearbyDuplicate3(int[] nums, int k) {
        //不使用 list 或者数组 因为数组头和尾巴塞数据时有问题，而且不需要记录坐标了
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
           if(i>k){
               set.remove(nums[i - k - 1]);
           }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums ={99,99};
        int k = 4;
        boolean b = containsNearbyDuplicate3(nums, k);
        System.err.println(b);
    }
}
