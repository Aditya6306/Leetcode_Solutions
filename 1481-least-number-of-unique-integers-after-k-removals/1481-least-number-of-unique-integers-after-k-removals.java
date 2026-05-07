class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr) map.put(ele, map.getOrDefault(ele, 0)+1);
        int n=map.size();
        int[] nums = new int[n];
        int i=0;
        for(int ele : map.keySet()){
            nums[i]=map.get(ele);
            i++;
        }
        Arrays.sort(nums);

        int ans=0, j=0;
        while(j<n){
            if(k>=nums[j]){
                 k -= nums[j]; 
            }
            else{
                 ans=n-j;
                 break;
            }
            j++;

        }
        return ans;
    }
}