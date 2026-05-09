class Solution {
    public int count(int idx, ArrayList<Integer> list, int target, int[][] dp){
        if(target == 0) return 0;
        
        if(idx == list.size()) return Integer.MAX_VALUE;
        
        if(dp[idx][target] != -1) return dp[idx][target];
        long pick = Integer.MAX_VALUE;
        if(target - list.get(idx) >= 0) pick = 1L+count(idx, list, target-list.get(idx), dp);
        long skip = count(idx+1, list, target, dp);

        return dp[idx][target] = (int)Math.min(pick, skip);
    }
    public int numSquares(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }
        int s=list.size();
        int[][] dp = new int[s+1][n+1];
        for(int[] ele : dp) Arrays.fill(ele, -1);

        int ans = count(0, list, n, dp);
        return ans;
    }
}