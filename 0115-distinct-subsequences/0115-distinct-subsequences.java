class Solution {
    public int calculate(String s, String t, int i, int j, int[][] dp){
        if(i>=s.length()){
            if(j>=t.length()) return 1;
            return 0;
        }
        if(j>=t.length()) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        char a = s.charAt(i);
        char b = t.charAt(j);
        int ans=0;
        if(a==b){
            ans += calculate(s, t, i+1, j+1, dp);
            ans+= calculate(s, t, i+1, j, dp);
        }
        else ans+=calculate(s, t, i+1, j, dp);
        return dp[i][j] = ans;
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        // sb = new StringBuilder();
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return calculate(s, t, 0, 0, dp);
    }
}