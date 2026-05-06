class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int max=1;
        if(arr[0]!=1) arr[0]=1; 
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i]-arr[i-1])<=1) {
                max=Math.max(arr[i], max);
                continue;
            }
            arr[i]=arr[i-1]+1;
            max=Math.max(arr[i], max);
        }
        return max;
    }
}