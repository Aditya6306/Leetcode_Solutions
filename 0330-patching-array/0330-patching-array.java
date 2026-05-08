class Solution {
    public int minPatches(int[] nums, int n) {
        int ans=0;
        long maxReach=0;
        int i=0;
        int k=nums.length;
        while(n>maxReach){
            if(i<k){
                if(nums[i] <= maxReach+1) maxReach = nums[i++]+maxReach;
                else{
                    maxReach = maxReach+ (maxReach+1);
                    ans++;
                }
            }
            else{
                maxReach = maxReach+ (maxReach+1);
                ans++;
            }
        }
        return ans;
    }
}