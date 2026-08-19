class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        Arrays.sort(lights);
        int max = lights[lights.length-1];
        int ans=0;
        for(int i=0;i<arrivalTime.length;i++){
            int r = arrivalTime[i]%period;
            if(r<max) continue;
            else{
                int wt = period-r;
                ans = Math.max(ans, wt);
            }
        }
        return ans;
    }
}