class Solution {
    public int calc(ArrayList<Long> list, int num){
        int lo=0, hi = list.size()-1;
        int pre=-1;
        int toIns=-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(list.get(mid)<num) {
                pre=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        lo=0; hi=list.size()-1;
        long n=(long)num*2;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(list.get(mid)<=n){
                toIns=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        list.add(toIns+1, n);
        return pre+1;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        ArrayList<Long> list = new ArrayList<>();

        list.add((long)nums[n-1]*2);
        int ans=0;
        for(int i=n-2;i>=0;i--){
            ans += calc(list, nums[i]);            
        }
        return ans;
    }
}