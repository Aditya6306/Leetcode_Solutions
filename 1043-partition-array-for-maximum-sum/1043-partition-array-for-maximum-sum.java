class Solution {
    public int calculate(int[] arr, int k, int i, int[] dp){
        if(i==arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int max=Integer.MIN_VALUE;
        int m=-1;
        for(int j=i;j<Math.min(arr.length, i+k); j++){
            m=Math.max(m, arr[j]);
            int sum = (j-i+1)*m + calculate(arr, k, j+1, dp);
            max=Math.max(sum, max);
        }
        return dp[i] = max;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return calculate(arr, k, 0, dp);
    }
}