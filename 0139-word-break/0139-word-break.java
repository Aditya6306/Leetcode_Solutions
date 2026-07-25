class Solution {
    public boolean check(String s, HashSet<String> set, int i, int j, int[][] dp){
        if(j>=s.length()){
            String st=s.substring(i, j);
            if(set.contains(st)) return true;
            return false;
        }
        if(dp[i][j] != -1) return dp[i][j]==1;
        String sub = s.substring(i, j);
        boolean ans=false;
        if(set.contains(sub)){
            ans = ans || check(s, set, j, j+1, dp);
        }
        ans = ans || check(s, set, i, j+1, dp);
        dp[i][j] = (ans==true) ? 1:0;
        return ans;
        

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int[][] dp = new int[s.length()][s.length()];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        for(String ele : wordDict){
            set.add(ele);
        }
        return check(s, set, 0, 1, dp);
    }
}