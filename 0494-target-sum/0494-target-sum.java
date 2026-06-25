class Solution {
    static int sum;
    public int ways(int i, int[] nums,int res, int target, int[][] dp) {
        if(i==nums.length){
            if(target==res) return 1;
            else return 0;
        }
        if(dp[i][sum+res]!=-1) return dp[i][sum+res];
        int add = ways(i+1, nums ,res+nums[i], target, dp);
        int sub = ways(i+1, nums, res-nums[i],  target, dp);
        return dp[i][sum+res]=add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        sum=0;
        for(int ele : nums){
            sum+=ele;
        }
        int[][] dp=new int[n][2*sum+1];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        return ways(0,nums,0, target, dp);
    }
}