class Solution {
    public int calculate(int[] prices, int fee, int i, boolean canBuy, int[][] dp){
        if(i>=prices.length) return 0;
        int j=0;
        if(canBuy) j = 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(canBuy){
            int buy = -prices[i]+calculate(prices, fee, i+1, false, dp);
            int notBuy = calculate(prices, fee, i+1, true, dp);
            return dp[i][j] = Math.max(buy, notBuy);
        
        }
        else{
            int sell = prices[i]-fee+calculate(prices, fee, i, true, dp);
            int hold = calculate(prices, fee, i+1, false, dp);
            return dp[i][j] = Math.max(sell, hold);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] ele:dp) Arrays.fill(ele, -1);
        return calculate(prices, fee, 0, true, dp);
    }
}