class Solution {
    public int firstMissingPositive(int[] nums) {
        int limit = (int)1e5+1;
        int arr[] = new int[limit];
        Arrays.fill(arr, -1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] >=0 && nums[i]<limit){
                arr[nums[i]]=1;
            }
            
        }
        int i;
        for(i=1;i<limit;i++){
            if(arr[i]==-1) break;
        }
        return i;
    }
}