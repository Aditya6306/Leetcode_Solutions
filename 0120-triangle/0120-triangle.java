class Solution {
    public int calculate(List<List<Integer>> list, int i, int j, int[][] dp){
        if(i>=list.size() || j>=list.get(i).size()) return Integer.MAX_VALUE;
        if(i==list.size()-1) return list.get(i).get(j);
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int bottom = list.get(i).get(j)+calculate(list, i+1, j, dp);
        int bottomRight = list.get(i).get(j)+calculate(list, i+1, j+1, dp);
        return dp[i][j] = Math.min(bottom, bottomRight);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=triangle.get(0).size();
        int[][] dp = new int[m+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        return calculate(triangle, 0, 0, dp);
    }
}