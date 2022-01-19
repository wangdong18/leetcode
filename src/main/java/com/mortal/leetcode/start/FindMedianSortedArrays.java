package com.mortal.leetcode.start;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author mortal
 * @create 2022/1/11 10:27
 */
public class FindMedianSortedArrays {
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        int current = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int i1 = 0; i < nums2.length; i++) {
                if (nums1[i]< nums2[i1]) {
                    ints[current] = nums1[i];
                }else {
                    ints[current] = nums2[i1];
                }
                current++;
            }
        }
        int anInt = ints[(ints.length+1)/ 2];
        if (ints.length%2==0) {
            return (anInt + ints[(ints.length) / 2]) / 2;
        }
        return anInt;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.err.println(medianSortedArrays);
    }
}
