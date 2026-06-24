class Solution {
    public int calculate(int[][] arr, int i, int j, int[][] dp){
        int m=arr.length;
        int n= arr[0].length;
        if(i==m || j==n) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        if(i==m-1 && j==n-1) return arr[i][j];
        return dp[i][j] = arr[i][j]+Math.min(calculate(arr, i+1, j, dp), calculate(arr, i, j+1, dp));
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = calculate(grid, 0, 0, dp);
        return ans;
    }
}