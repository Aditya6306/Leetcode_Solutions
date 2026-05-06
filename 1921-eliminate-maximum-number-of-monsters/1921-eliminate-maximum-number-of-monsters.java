class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double time[] = new double[n];
        for(int i=0;i<n;i++){
            time[i]=(double)dist[i]/(double)speed[i];
        }
        Arrays.sort(time);
        int currTime=1;
        int i=1;
        int ct=1;
        while(i<n){
            if(currTime>=time[i]) break;
            ct++;
            currTime++;
            i++;
        }
        return ct;
    }
}