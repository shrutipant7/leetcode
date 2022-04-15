class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        int[] maxPriceArray = new int[prices.length];
        int profit = 0;
        for(int i=prices.length-1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxPriceArray[i] = maxPrice;
        }
        for(int i=0; i<prices.length; i++) {
            profit = Math.max(profit, maxPriceArray[i]-prices[i]);
        }
        return profit;
    }
}
