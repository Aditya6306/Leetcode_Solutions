class Solution {
    public boolean check(String s1, String s2, String s3, int i, int j, int k, int[][] dp){
        if(i==s1.length() && j==s2.length() && i+j == s3.length()) return true;
        
        if(i+j == s3.length() ) return false;
        if( dp[i][j] != -1) return dp[i][j] == 1;
      
        
        boolean ans = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k) ){
            ans = check(s1, s2, s3, i+1, j, k+1, dp);
        }
        if(ans) {
            dp[i][j] = (ans) ? 1 : 0;
            return ans;
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            ans = check(s1, s2, s3, i, j+1, k+1, dp);
        }
        dp[i][j] = (ans) ? 1 : 0;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int x= Math.max(s1.length(), s2.length());

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return check(s1, s2, s3, 0, 0, 0, dp);
    }
}