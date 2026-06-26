class Solution {
    public int calculate(String s, int i, int j, int[][] dp){
        if(i>=j) return 0;
        char a = s.charAt(i);
        char b = s.charAt(j);
        if(dp[i][j] != -1) return dp[i][j];
        int ans=0;
        if(a==b) ans = calculate(s, i+1, j-1, dp);
        else{
            ans = 1+Math.min(calculate(s, i+1, j, dp), calculate(s, i, j-1, dp));
        }
        return dp[i][j] = ans;
    }
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return calculate(s, 0, s.length()-1, dp);
    }
}