class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            return a[1]-b[1];
        });

        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int start = intervals[0][0]; 
        int end = intervals[0][1];
        int ct=0;
        for(int i=1;i<intervals.length;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart < end){
                ct++; 
            }
            else{
                start = currStart;
                end = currEnd;
            }
        } 
        return ct;
    }
}