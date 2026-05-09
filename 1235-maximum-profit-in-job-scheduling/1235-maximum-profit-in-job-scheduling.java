class Solution {
    public int getNext(int[][] arr, int lo, int curr){
        int hi=arr.length-1;
        int idx=arr.length+1;
        while(lo<=hi){
            
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid][0]>=arr[curr][1]){
                idx=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }

        return idx;
    }
    public int maxProfit(int[][] arr, int curr, int[] dp) {
        if(curr >= arr.length) return 0;

        int pick = 0;
        int skip = 0;
        if(dp[curr] != -1) return dp[curr];
        int idx = getNext(arr, curr+1, curr);
        pick = arr[curr][2]+maxProfit(arr, idx, dp);
        skip = maxProfit(arr, curr+1, dp);
        int ans=Math.max(pick, skip);
        
        
        return dp[curr] = ans;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int arr[][]= new int[n][3];
        int[] dp = new int[profit.length+1];
        Arrays.fill(dp, -1);
        for(int i=0;i<n;i++){
            arr[i]=new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(arr, (a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        return maxProfit(arr, 0, dp);
    }
}