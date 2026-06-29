class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            return a[1]-b[1];
        });

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

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
        // if(list.size()==0 ||  list.get(list.size()-1).get(1) != intervals[intervals.length-1][1]){
        //     list.add(new ArrayList<>(Arrays.asList(start, end)));
        // }
        // int[][] ans = new int[list.size()][2];
        // for(int i=0;i<list.size();i++){
        //     ans[i][0]=list.get(i).get(0);
        //     ans[i][1]=list.get(i).get(1);
        // }
        return ct;
    }
}