class Solution {
    public int calculate(int m, int n, int i, int j, int[][] dp){
        if(i==m || j==n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = calculate(m, n, i+1, j, dp) + calculate(m, n, i, j+1, dp);
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return calculate(m, n, 0, 0, dp);
    }
}