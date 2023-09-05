package maxProfit;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
class Solution {

    public static void main(String[] args) {
        int[] prices = new int[]{
                7,1,5,3,6,4
        };
        int i = maxProfit(prices);
        System.err.println(i);
    }

    //计算数组间隔的最大值
    //遍历循环2次比较耗时间
    //官方这个逻辑也超时
    public static int maxProfit(int[] prices) {
        int result = 0;
        int index = 0;
        for (int i = 1; i < prices.length&&index<prices.length; i++) {
            int temp = prices[i] - prices[index];
            if (temp > 0 && temp > result) {
                result = temp;
            }
            index++;
        }
        return result;
    }
}
