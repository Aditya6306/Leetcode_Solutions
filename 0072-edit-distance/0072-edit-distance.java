class Solution {
    public int calculate(StringBuilder w1, StringBuilder w2, int i, int j, int[][] dp) {
        if (j >= w2.length() )
            return w1.length()-i;
        if (i>=w1.length())
            return w2.length()-j;
        if(dp[i][j] != -1) return dp[i][j];
        char a = w1.charAt(i);
        char b = w2.charAt(j);
        int ans;
        if(a == b) ans = calculate(w1, w2, i+1, j+1, dp);
        else{
            int rep = calculate(w1, w2, i+1, j+1, dp);
            int del = calculate(w1, w2, i+1 , j, dp);
            int ins = calculate(w1, w2, i, j+1, dp);

            ans=1+Math.min(rep, Math.min(del, ins));

        }
        return dp[i][j] = ans;
    }

    public int minDistance(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        int[][] dp = new int[word1.length()][word2.length()];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return calculate(sb1, sb2, 0, 0, dp);
    }
}