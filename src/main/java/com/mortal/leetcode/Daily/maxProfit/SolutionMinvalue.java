package maxProfit;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
class SolutionMinvalue {

    public static void main(String[] args) {
        int[] prices = new int[]{
                7,2,9,1,6,4
        };
        int i = maxProfit(prices);
        System.err.println(i);
    }

    //将今天和最低的时间进行比较
    //当存在前面的最小值比后面最小值大时
    //如果后面没有更大的最大值，最大值是不会发生变化的
    public static int maxProfit(int[] prices) {
        int result = 0;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minNumber) {
                minNumber = prices[i];
            } else if (prices[i] - minNumber > result) {
                result = prices[i] - minNumber;
            }
        }
        return result;
    }
}
