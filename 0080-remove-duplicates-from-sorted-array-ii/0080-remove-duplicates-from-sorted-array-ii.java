class Solution {
    public int removeDuplicates(int[] nums) {
        int ct=1;
        int i=1, j=1;
        while(i<nums.length){
            if(nums[i] == nums[j-1] && ct<2){
                nums[j]=nums[i];
                j++;
                ct++;
            }
            else if(nums[i] == nums[j-1] && ct==2) ;
            else{
                nums[j] = nums[i];
                ct=1;
                j++;
            }
            i++;
        }
        return j;
    }
}