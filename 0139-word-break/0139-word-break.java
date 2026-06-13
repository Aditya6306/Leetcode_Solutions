class Solution {
    public static boolean helper(HashSet<String> set, int i, String s, int[] dp){
        if(set.contains(s.substring(i))) return true;
        if(i==s.length()) return false;
        if(dp[i] == 1) return true;
        if(dp[i] == -1) return false;

        for(int j=i;j<s.length();j++){
            String str = s.substring(i, j+1);
            // System.out.println(str+" ");
            if(set.contains(str)){
                if(helper(set, j+1, s, dp)) {
                    dp[i] = 1;
                    return true;
                }
            }

        }
        dp[i]=-1;
        return false;
    }
    public boolean wordBreak(String st, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int[] dp = new int[st.length()];
        for(String s : wordDict) set.add(s);

        return helper(set, 0, st, dp);
    }
}