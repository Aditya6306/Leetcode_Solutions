class Solution {
    public long calculate(int[] coins, int amount, int i, long[][] dp){
        if(amount==0) return 0;
        if(i<0) return Integer.MAX_VALUE;
        if(dp[i][amount] != -1) return dp[i][amount];
        long pick=Integer.MAX_VALUE;
        if(coins[i]<=amount) pick = 1+calculate(coins, amount-coins[i], i, dp);
        long skip = calculate(coins, amount, i-1, dp);
        return dp[i][amount] = Math.min(pick, skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        Arrays.sort(coins);
        long[][] dp = new long[n][amount+1];
        for(long[] arr : dp){
            Arrays.fill(arr, -1);
        }
        long ans = calculate(coins, amount, n-1, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
}