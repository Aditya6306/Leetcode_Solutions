class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int time[] = new int[n];
        for(int i=0;i<n;i++){
            time[i]=(int)Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(time);
        int currTime=1;
        int i=1;
        int ct=1;
        // System.out.println(time[1]);
        while(i<n){
            if(currTime>=time[i]) break;
            ct++;
            currTime++;
            i++;
        }
        return ct;
    }
}