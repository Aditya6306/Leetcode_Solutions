class Solution {
    public int maximumScore(int[] nums, int k) {
        int l=k, r=k;
        int currMin = nums[k];
        int currScore=nums[k];
        int maxScore=nums[k];
        int n=nums.length;
        while(l>=0 && r<n){
            int left=0;
            if(l-1 >= 0)left = nums[l-1];
            int right=0;
            if(r+1 < n)right = nums[r+1];

            if(left<right){
                r++;
                currMin = Math.min(currMin, right);
                currScore = currMin*(r-l+1);
                maxScore = Math.max(maxScore, currScore);

            }
            else{
                l--;
                currMin = Math.min(currMin, left);
                currScore = currMin*(r-l+1);
                maxScore = Math.max(maxScore, currScore);
            }
        }
        return maxScore;
    }
}