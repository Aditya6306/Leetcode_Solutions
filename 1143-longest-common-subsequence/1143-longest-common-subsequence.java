class Solution {
    StringBuilder sb;
    public int calculate(String t1, String t2, int i, int j, int[][] dp, String s){
        if(i>=t1.length() || j>=t2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        char a = t1.charAt(i);
        char b = t2.charAt(j);
        int ans=0;
        if(a == b) {
            ans= 1+calculate(t1, t2, i+1, j+1, dp, s+a);
            String str = s+a;
            if(str.length() > sb.length()) {
                sb.replace(0, sb.length(), str);
            }
        }
        else{
            ans = Math.max(calculate(t1, t2, i+1, j, dp, s), calculate(t1, t2, i, j+1, dp, s));
        }
        return dp[i][j] = ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        sb=new StringBuilder();
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = calculate(text1, text2, 0, 0, dp,"");
        System.out.println(sb);
        return ans;
    }
}