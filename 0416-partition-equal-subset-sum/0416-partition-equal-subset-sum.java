class Solution {
    public boolean calculate(int[] nums, int i, int target, int[][] dp){
        if(i==nums.length){
            return target == 0;
        }
        if(dp[i][target] != -1) return dp[i][target] == 1;
        boolean pick = false;
        if(target >= nums[i]) pick = calculate(nums, i+1, target-nums[i], dp);
        boolean skip = calculate(nums, i+1, target, dp);
        dp[i][target] = (pick || skip) ? (1) : (0);
        return pick || skip;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum+=ele;
        if(sum % 2 != 0) return false;
        int[][] dp = new int[nums.length][(sum/2)+1];
        for(int[] arr : dp){
                Arrays.fill(arr, -1);
        }

        return calculate(nums, 0, sum/2, dp);
    }
}