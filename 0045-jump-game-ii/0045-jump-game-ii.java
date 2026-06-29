class Solution {
    public int count(int[] nums, int i, int[] dp){
        if(i==nums.length-1) return 0;
        if(dp[i] != -1) return dp[i];
        int ct=nums.length;
        for(int j=1;j<=nums[i] && j+i < nums.length;j++){
            int cal = 1+count(nums, i+j, dp);
            ct=Math.min(ct, cal);
        }
        return dp[i] = ct;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return count(nums, 0, dp);
    }
}