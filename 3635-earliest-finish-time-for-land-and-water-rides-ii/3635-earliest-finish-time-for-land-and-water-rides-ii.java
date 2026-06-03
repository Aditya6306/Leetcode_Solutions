class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // int res=0;
        int minAns = Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            int res=0;
            res += landStartTime[i]+landDuration[i];
            minAns=Math.min(res, minAns); 
        }
        
        for(int i=0;i<waterStartTime.length;i++){
            int res=0;
            res += Math.max(minAns, waterStartTime[i])+waterDuration[i];
            ans = Math.min(ans, res);
        }

        // int res=2;
        int minAns2 = Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            int res2=0;
            res2 += waterStartTime[i]+waterDuration[i];
            minAns2=Math.min(res2, minAns2); 
        }
        
        for(int i=0;i<landStartTime.length;i++){
            int res2=0;
            res2 += Math.max(minAns2, landStartTime[i])+landDuration[i];
            ans = Math.min(ans, res2);
        }

        return ans;
    }
}