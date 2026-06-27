class Solution {
    public int calculate(int[] prices, int currDay, boolean canBuy, int[][] dp){
        if(currDay >= prices.length) return 0;

        int j=0;
        if(canBuy) j = 1;
        if(dp[currDay][j] != -1) return dp[currDay][j];
        if(canBuy){
            int buy = -prices[currDay] + calculate(prices, currDay+1, false, dp);
            int notBuy = calculate(prices, currDay+1, canBuy, dp);
            return dp[currDay][j] = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[currDay] + calculate(prices, currDay+2, true, dp);
            int hold = calculate(prices, currDay+1, canBuy, dp);
            return dp[currDay][j] = Math.max(sell, hold);
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] ele:dp) Arrays.fill(ele, -1);
        return calculate(prices, 0, true, dp);
    }
}