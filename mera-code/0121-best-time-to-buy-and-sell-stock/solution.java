class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[prices.length - 1];
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max)
                max = prices[i];
            else {
                profit = Math.max(profit, max - prices[i]);
            }
        }
        return profit;
    }
}
