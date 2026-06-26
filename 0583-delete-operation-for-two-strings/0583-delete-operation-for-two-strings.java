class Solution {
    public int calculate(String w1, String w2, int i, int j, int[][] dp){
        if(i>=w1.length()) {
            return w2.length()-j;
        }
        if(j>=w2.length()) {
            return w1.length()-i;
        }
        if(dp[i][j] != -1) return dp[i][j];
        char a=w1.charAt(i);
        char b=w2.charAt(j);
        int ans=0;

        if(a==b) ans = calculate(w1, w2, i+1, j+1, dp);
        else ans = 1+Math.min(calculate(w1, w2, i+1, j, dp), calculate(w1, w2, i, j+1, dp));
        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return calculate(word1, word2, 0, 0, dp);
    }
}