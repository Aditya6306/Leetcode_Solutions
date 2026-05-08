class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n= nums.length;
        int[] arr = new int[n];
        arr[0]=1;
        arr[n-1]=n-2;
        for(int i=1;i<n-1;i++){
            int leftDiff = Math.abs(nums[i]-nums[i-1]);
            int rightDiff = Math.abs(nums[i]-nums[i+1]);
            if(leftDiff <= rightDiff) arr[i]=i-1;
            else arr[i] = i+1;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        int[] leftToRight = new int[n];
        for(int i=1;i<n;i++){
            if(arr[i-1] == i){
                leftToRight[i]=leftToRight[i-1]+1;
            }
            else{
                leftToRight[i]=Math.abs(nums[i]-nums[i-1])+leftToRight[i-1];
            }
        }

        int[] rightToLeft = new int[n];
        for(int i=n-2;i>=0;i--){
            if(arr[i+1] == i){
                rightToLeft[i]=rightToLeft[i+1]+1;
            }
            else{
                rightToLeft[i]=Math.abs(nums[i]-nums[i+1])+rightToLeft[i+1];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];
        
        for(int i=0;i<m;i++){
            int st=queries[i][0];
            int end=queries[i][1];
            System.out.println(leftToRight[st]);
            System.out.println(leftToRight[end]);
            if(st > end){
                ans[i]=rightToLeft[end]-rightToLeft[st];
            }
            else{
                ans[i]=leftToRight[end]-leftToRight[st];
            }
        }

        return ans;
    }
}