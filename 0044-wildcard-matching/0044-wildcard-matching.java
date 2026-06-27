class Solution {
    public boolean match(String s, String p, int i, int j, int[][] dp){
        if(i>=s.length() ) {
            if(j>=p.length()) return true;
            else{
                if(p.charAt(j) == '*') return match(s, p, i, j+1, dp);
                return false;
            }
        }
        if(j>=p.length()) return false;

        if(dp[i][j] != -1) return dp[i][j] == 1;
        char a = s.charAt(i);
        char b = p.charAt(j);

        boolean ans=false;
        if(a == b) ans = match(s, p, i+1, j+1, dp);
        else if(b=='*'){
            
            ans = match(s, p, i, j+1, dp) || match(s, p, i+1, j, dp);
            
        }
        else if(b=='?') ans = match(s, p, i+1, j+1, dp);
        else ans = false;
        dp[i][j] = (ans) ? 1 : 0;
        return ans;
    }
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return match(s, p, 0, 0, dp);
    }
}