class Solution {
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
        int pre =Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return calculate(nums, 0, -1, dp);
    }
}