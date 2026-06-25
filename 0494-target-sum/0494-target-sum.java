class Solution {
    public int calculate(int[] nums, int i, int target, int curr){
        
        if(i>=nums.length) {
            if(curr == target) return 1;
            return 0;
        }

        int add = calculate(nums, i+1, target, curr+nums[i]);
        int sub = calculate(nums, i+1, target, curr-nums[i]);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, target, 0);
    }
}