package mergeOrderedArray;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class SolutionEndeIndex {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;

        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.err.print(i);
        }

    }

    //逆向指针排序，nums1中总有位置塞入nums2中的数据 塞入大的
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1,total=m+n-1;
        int cur = 0;
        while (p1 >-1 ||  p2>-1) {
            if (p1 == 0) {
                cur = nums2[p2--];
            } else if (p2 == 0) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[total--] = cur;
        }
    }
}


