class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        HashMap<Long, Integer> arr[] = new HashMap[n];
        for(int i=0;i<n;i++){
            arr[i] = new HashMap<>();
        }
        int ans=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                long diff=(long)nums[i]-(long)nums[j];

                if(arr[j].containsKey(diff)){
                    ans+=arr[j].get(diff);
                    
                    arr[i].put(diff, arr[i].getOrDefault(diff, 0)+arr[j].get(diff)+1);
                }
                else{
                    arr[i].put(diff, arr[i].getOrDefault(diff, 0)+1);
                }
            }
        }
        return ans;
    }
}