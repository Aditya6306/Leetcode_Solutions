class Solution {
    public boolean check(int[] nums, int i, int[] dp){
        if(i>=nums.length-1) return true;
        if(nums[i] == 0) return false;
        if(dp[i] != -1) return dp[i]==1;
        boolean ans = false;
        for(int j=i+1;j<=nums[i]+i;j++){
            ans =  check(nums, j, dp);
            if(ans) return ans;
        }
        dp[i] = (ans) ? 1 : 0;
        return  ans;
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return check(nums, 0, dp);

    }
}