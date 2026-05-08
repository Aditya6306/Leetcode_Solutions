class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : banned) set.add(ele);
        int currSum=0;
        int ans=0;
        for(int i=1;i<=n;i++){
            if(set.contains(i)) continue;
            if(currSum + i > maxSum) return ans;
            ans++;
            currSum += i;
        }
        return ans;
    }
}