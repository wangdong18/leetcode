package maxProfit3;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
class Solution {
    public static void main(String[] args) {
        int[] prices = new int[]{
                1, 2, 3, 4, 5, 6
        };
        System.err.println(maxProfit(prices));
    }


    /**
     * 五种状态
     * 每天就 一次没买，买卖一次，买卖两次
     * 第一种排除，记录剩下四种的最大值
     * buy1',buy2',sell1',sell2'表示当天的状态，此例子中是相等的
     * 买一次的价格 buy1=Max{buy1',-price[i]}
     * 卖一次的价格 sell1=Max{sell1',buy1+price[i]}
     * 买两次的价格 buy2=Max{buy2',sell1-price[i]}
     * 卖两次的价格 sell2=Max{sell2',buy2+price[i]}
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

}
