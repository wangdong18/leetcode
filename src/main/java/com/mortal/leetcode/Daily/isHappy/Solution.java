package isHappy;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * @auther mortal
 * @date 2023/9/26 22:04
 */
public class Solution {

    public static void main(String[] args) {
        System.err.println(isHappy(19));
    }

    //只要存在回路 必会存在循环
    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int add = 0;
        Set<Integer> set = new HashSet<>();
        while (add < Integer.MAX_VALUE && n < Integer.MAX_VALUE ) {
            while (n > 0) {
                int mu = n % 10;
                add = add + mu * mu;
                n = n / 10;
            }
            if (add == 1) {
                return true;
            } else {
                if (set.contains(add)) {
                    return false;
                }
                n = add;
                set.add(add);
                add = 0;
            }
        }
        return false;
    }
}
