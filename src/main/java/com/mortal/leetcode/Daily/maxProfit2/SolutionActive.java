package maxProfit2;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，
 * 然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
class SolutionActive {
    public static void main(String[] args) {
        int[] prices = new int[]{
                1, 2, 3, 4, 5
        };
        System.err.println(maxProfit(prices));
    }


    //动态规划
    //定义dp[i][0]表示没有股票的最大收益，dp[i][1]表示有股票的最大收益
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //当天的价格=昨天价格和今天买入或者卖出的价格的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
