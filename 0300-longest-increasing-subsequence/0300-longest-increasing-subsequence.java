class Solution {
    String st;
    public int calculate(int[] nums, int i, int pre, int[][] dp){
        if(i>=nums.length) return 0;

        if( dp[i][pre+1] != -1) return dp[i][pre+1];
        int take = 0;

        if(pre==-1)take=1+calculate(nums, i+1, i, dp);
        else if(nums[pre]<nums[i]) take=1+calculate(nums, i+1, i, dp);
        int skip = calculate(nums, i+1, pre, dp);
        
        return dp[i][pre+1] = Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                    max=Math.max(dp[i], max);
                }

            }
        }
        return max;
    }
}