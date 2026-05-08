class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int hp =1, vp=1;

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        long ans=0;
        int i=m-2, j=n-2;
        while(j>=0 || i>=0){
            if(j>=0 && i>=0){
                if(horizontalCut[i]>=verticalCut[j]){
                    ans+=horizontalCut[i]*vp;
                    hp++;
                    i--;
                }
                else{
                    ans+=verticalCut[j]*hp;
                    vp++;
                    j--;
                }

            }
            else if(j>=0){
                
                    ans+=verticalCut[j]*hp;
                    vp++;
                    j--;
                

            }
            else{
                ans+=horizontalCut[i]*vp;
                hp++;
                i--;
            }
        }

        return ans;
    }
}