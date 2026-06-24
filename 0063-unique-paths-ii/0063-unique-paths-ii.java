class Solution {
    public int calculate(int[][] arr, int i, int j, int[][] dp){
        int m=arr.length;
        int n= arr[0].length;
        if(i==m || j==n) return 0;
        if(arr[i][j] == 1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = calculate(arr, i+1, j, dp) + calculate(arr, i, j+1, dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return calculate(obstacleGrid, 0, 0, dp);
    }
}