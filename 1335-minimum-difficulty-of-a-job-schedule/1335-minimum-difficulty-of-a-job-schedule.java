class Solution {
    public int solve(int[] jobDifficulty, int d, int idx, int[][] dp){
        int n=jobDifficulty.length;

        if(d == 1){
            int max = Integer.MIN_VALUE;
            for(int i=idx;i<n;i++){
                max=Math.max(max, jobDifficulty[i]);
            }
            return max;
        }
        if(dp[d][idx] != -1)return dp[d][idx];
        int result=Integer.MAX_VALUE;
        
        int maxD = jobDifficulty[idx];
        for(int i=idx;i<=n-d;i++){
            maxD=Math.max(maxD, jobDifficulty[i]);
            int ans = maxD+solve(jobDifficulty, d-1, i+1, dp);
            result = Math.min(ans, result);
        }
        return dp[d][idx] = result;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d)return -1;
        int[][] dp = new int[d+1][n+1];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        int ans = solve(jobDifficulty, d, 0, dp);
        return ans;
    }
}