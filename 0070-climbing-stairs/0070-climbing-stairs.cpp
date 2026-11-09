class Solution {
public:
    int find(int n, int curr, vector<int>& dp){
        if(curr>n) return 0;
        if(n==curr) return 1;
        if(dp[curr] != -1) return dp[curr];
        return dp[curr]=find(n, curr+1, dp) + find(n, curr+2, dp);
    }
    int climbStairs(int n) {
        vector<int> dp(n+1, -1);
        
        int ans = find(n, 0, dp);
        return ans;
    }
};