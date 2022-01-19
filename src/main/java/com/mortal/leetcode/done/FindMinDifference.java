package com.mortal.leetcode.done;

import java.util.*;

/**
 * @author mortal
 * @create 2022/1/18 10:53
 */
public class FindMinDifference {
    public static  int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String timePoint = timePoints.get(i);
            int innerArr = new Integer(timePoint.substring(0, 2)) * 60 + new Integer(timePoint.substring(3));
            arr[i] = innerArr;
        }
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            result=Math.min(arr[i] - arr[i-1], result);
        }
        return Math.min(1440+arr[0]-arr[timePoints.size()-1], result);
    }

    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<String>();
        objects.add("23:59");
        objects.add("23:58");
        objects.add("00:00");
        int minDifference = findMinDifference(objects);
        System.err.println(minDifference);
    }
}
