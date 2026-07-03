class Solution {
    // public int calculate(int[] nums, int i, int j, int length, int[][][] dp){
    //     if(length==0) return 1;
    //     if(i>=nums.length){
    //         if(length==0) return 1;
    //         return 0;
    //     }
    //     if(dp[i][j+1][length] != -1) return dp[i][j+1][length];
    //     int take=0;
    //     if(j==-1 || nums[i]>nums[j]){
    //         take = calculate(nums, i+1, i, length-1, dp);
    //     }
    //     int skip = calculate(nums, i+1, j, length, dp);
    //     return dp[i][j+1][length] = take+skip;
    // }
    public int findNumberOfLIS(int[] nums) {
        int[] inc = new int[nums.length];
        Arrays.fill(inc, 1);
        int max=0;
        int n=nums.length;
        int count[] = new int[nums.length];
        Arrays.fill(count, 1);
        int ans=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) {
                    if(inc[j]+1 > inc[i]){
                        inc[i]=inc[j]+1;
                        ans=Math.max(ans, inc[i]);
                        count[i]=count[j];
                    }
                    else if(inc[j]+1 == inc[i]){
                        count[i] += count[j];
                    }
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(inc[i]==ans) {
                max += count[i];
            }
        }
        return max;
        
    }
}