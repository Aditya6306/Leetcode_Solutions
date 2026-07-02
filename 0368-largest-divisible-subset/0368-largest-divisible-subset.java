class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int n=nums.length;
        int[] arr=new int[n];
        Arrays.fill(arr, -1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    int t=dp[i];
                    dp[i]=Math.max(dp[i], dp[j]+1);
                    if(dp[i]>t){
                        arr[i]=j;
                    }
                    max=Math.max(dp[i], max);
                }
            }
            // System.out.print(arr[i]+" ");
        }

        int maxIdx=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max){
                maxIdx=i;
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=max-1;i>=0 ;i--){
            if(maxIdx>=0){
                ans.add(0, nums[maxIdx]);
                maxIdx=arr[maxIdx];
            // System.out.println(ans.get(0));
            }
        }
        // System.out.println(ans);
        return ans;
    }
}