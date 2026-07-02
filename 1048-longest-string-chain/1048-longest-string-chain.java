class Solution {
    public boolean isValid(String a, String b){
        int i=0, j=0;
        int taken=0;
        while(i<a.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else if(taken==0){
                taken++;
                j++;
            }
            else return false;
        }
        return true;
    }
    public int count(String[] words, int i, int pre, int[][] dp){
        if(i>=words.length) return 0;
        if(dp[i][pre+1] != -1) return dp[i][pre+1];
        int take=0;
        if(pre==-1 || (words[i].length()==words[pre].length()+1 && isValid( words[pre], words[i]))){
            take=1+count(words, i+1, i, dp);
        }
        int skip = count(words, i+1, pre, dp);
        return dp[i][pre+1]= Math.max(take, skip);
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->{
            return a.length()-b.length();
        });
        int n=words.length;
        int[][] dp = new int[n][n];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        return count(words, 0, -1, dp);
    }
}