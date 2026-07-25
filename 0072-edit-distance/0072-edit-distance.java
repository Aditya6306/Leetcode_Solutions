class Solution {
    public int calculate(String w1, String w2, int i, int j, int[][] dp){
        if(j>=w2.length()){
            return w1.length()-i;
        }
        if(i>=w1.length()){
            return w2.length()-j;
        }
        if(dp[i][j] != -1) return dp[i][j];
        char a= w1.charAt(i);
        char b= w2.charAt(j);
        if(a == b){
            return dp[i][j] = calculate(w1, w2, i+1, j+1, dp);
        }
        else{
            int rep= 1+calculate(w1, w2, i+1, j+1, dp);
            int del = 1+calculate(w1, w2, i+1, j, dp);
            int ins = 1+calculate(w1, w2, i, j+1, dp);
            return dp[i][j] = Math.min(rep, Math.min(del, ins));
        }
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        return calculate(word1, word2, 0, 0, dp);
    }
}