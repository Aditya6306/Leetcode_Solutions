class Solution {
    public int minTaps(int n, int[] ranges) {
        int arr[] = new int[n+1];
        for(int i=0;i<n+1;i++){
            int left = i-ranges[i];
            if(left<0)left=0;
            arr[left]=Math.max(arr[left], i+ranges[i]);
        }

        int curr=0;
        int max=0;
        int tap=0;
        int i=0;
        while(i<n+1){
            if(i > max) return -1;
            if(curr < i){
                tap++;
                curr=max;
            }
            max=Math.max(arr[i], max);
            i++;
        }
        return tap;
    }
}