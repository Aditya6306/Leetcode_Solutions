class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length;
        int i=n-2;
        
        int ans=0;
        int j=n/3;
        while(j>0){
            ans+=piles[i];
            i=i-2;
            j--;
        }
        return ans;
    }
}