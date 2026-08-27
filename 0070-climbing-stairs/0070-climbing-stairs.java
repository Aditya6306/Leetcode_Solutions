class Solution {
    public int count(int n, int curr, int[] dp){
        if(curr==n) return 1;
        
        if(dp[curr] != -1 ) return dp[curr];
        int oneStep = count(n, curr+1, dp);
        int twoStep = 0;
        if(curr+2<=n) twoStep = count(n, curr+2, dp);
        return dp[curr] = oneStep+twoStep;
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return count(n ,0, dp);
    }
}