class Solution {
    public long maxAlternatingSum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        // Step 2: Make all elements positive using Absolute Value
        int[] nums = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            nums[k] = Math.abs(arr[k]);
        }
        
        // Step 3: Sort the array in ascending order
        Arrays.sort(nums);
        
        // Step 4: Two-pointer approach
        int i = 0;              // Start pointer (smallest elements)
        int j = nums.length - 1; // End pointer (largest elements)
        long score = 0;
        
        // Iterate until pointers meet
        while (i <= j) {
            if (i == j) {
                // Odd-length array: Middle element is added (positive term)
                score += nums[i]*nums[i]; 
            } else {
                // Alternate logic: Add large, Subtract small
                // Squared according to problem title and example
                score += (long)nums[j] * nums[j]; 
                score -= (long)nums[i] * nums[i];
            }
            
            // Move pointers inward
            i++;
            j--;
        }
        
        return score;
    }
}