class Solution {
    public boolean isPalindrome(String s, int i, int j){
        
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public int count(String s, int i, int j, int[][] dp){
        if(i>j) return 0;
        
        if(isPalindrome(s, i, j)) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        int max=s.length();
        for(int k=i+1;k<=j;k++){
            
            if(isPalindrome(s, i, k-1)){
                max=1+count(s, k, j, dp);
            }
            ans = Math.min(max, ans);
        }
        return dp[i][j] = ans;
    }
    public int minCut(String s) {
        if(isPalindrome(s, 0, s.length()-1)) return 0;
        int[][] dp =new int[s.length()][s.length()];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return count(s, 0, s.length()-1, dp)-1;
    }
}