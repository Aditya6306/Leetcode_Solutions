class Solution {
    public int calculate(int[] prices, int i, int ct, boolean canBuy, int[][][] dp){
        if(i>=prices.length) return 0;
        if(ct == 4) return 0;

        int j=0;
        if(canBuy) j=1;
        if(dp[i][j][ct] != -1) return dp[i][j][ct];
        if(canBuy){
            int buy = -prices[i]+calculate(prices, i+1, ct+1, false, dp);
            int notBuy = calculate(prices, i+1, ct, true, dp);
            return dp[i][j][ct] = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[i]+calculate(prices, i, ct+1, true, dp);
            int hold = calculate(prices, i+1, ct, false, dp);
            return dp[i][j][ct] = Math.max(sell, hold);
        }
    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][4];
        for(int[][] ele : dp){
            for(int[] arr : ele) Arrays.fill(arr, -1);
        }
        return calculate(prices, 0, 0, true, dp);
    }
}