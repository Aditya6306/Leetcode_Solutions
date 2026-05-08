class Solution {
    public int minIncrementForUnique(int[] arr) {
        int ans=0, n=arr.length;
        Arrays.sort(arr);

        for(int i=1;i<n;i++){
            if(arr[i]<=arr[i-1]){
                ans+=arr[i-1]-arr[i]+1;
                arr[i]=arr[i-1]+1;
            }
        }
        return ans;
    }
}