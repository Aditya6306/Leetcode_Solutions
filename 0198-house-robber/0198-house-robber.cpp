class Solution {
public:
    int calculate(vector<int>& nums, int i, vector<int>& dp){
        if(i>=nums.size()) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i]+calculate(nums, i+2, dp);
        int skip = calculate(nums, i+1, dp);
        return dp[i] = max(take, skip);
    }
    int rob(vector<int>& nums) {
        vector<int> dp(nums.size(), -1);
        int ans = calculate(nums, 0, dp);
        return ans;
    }
};