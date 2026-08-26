class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1, j=1, pre=nums[0];
        while(j<nums.length){
            if((nums[j]==nums[i] && j!=i) || nums[j]==pre){
                j++;
                
            }
            else{
                nums[i]=nums[j];
                pre=nums[j];
                i++;
                j++;

            }
        }
        return i;
    }
}