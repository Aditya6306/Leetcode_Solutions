class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] ){
                    int t=dp[i];
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                    max=Math.max(dp[i], max);
                    if(dp[i]>t)arr[i]=j;
                }

            }
        }
        return max;
    }
}