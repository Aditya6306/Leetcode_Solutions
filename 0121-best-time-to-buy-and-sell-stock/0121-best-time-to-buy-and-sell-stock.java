class Solution {
    public int profit(int[] prices, int i, boolean canBuy, int[][] dp){
        if(i>=prices.length) return 0;

        int j=0;
        if(canBuy) j=1;
        if(dp[i][j] != -1) return dp[i][j];
        // int pick;
        // int skip;
        if(canBuy){
            int pick = -prices[i]+profit(prices, i+1 , false, dp);
            int skip = profit(prices, i+1, true, dp);
            return dp[i][j] = Math.max(pick, skip);
        }
        else{
            int pick=prices[i];
            int skip = profit(prices, i+1, false, dp);
            return dp[i][j] = Math.max(pick, skip);
        }
        
        
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        return profit(prices, 0, true, dp);
    }
}