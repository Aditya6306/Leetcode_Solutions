class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans=0;
        int i=0;
        int n=happiness.length;
        int j=n-1;
        Arrays.sort(happiness);
        while(j>=0 && k>0){
            ans += Math.max(happiness[j]-i, 0);
            i++;
            j--;
            k--;
        }
        return ans;
    }
}