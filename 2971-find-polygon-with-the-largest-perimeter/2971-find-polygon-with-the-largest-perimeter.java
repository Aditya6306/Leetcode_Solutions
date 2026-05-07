class Solution {
    public long largestPerimeter(int[] nums) {
        int n=nums.length;
        long currSum = 0;
        long ans=0;
        Arrays.sort(nums);
        int i=0;
        while(i<n){
            
            if(i>=2 && currSum > nums[i]){
                ans = Math.max(ans, currSum+nums[i]);
            }
            currSum += nums[i];
            i++;
        }
        if(ans == 0) return -1;
        return ans;
    }
}