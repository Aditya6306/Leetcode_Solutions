class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            return a[0]-b[0];
        });

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int start = intervals[0][0]; 
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart > end){
                list.add(new ArrayList<>(Arrays.asList(start, end)));
                start = currStart;
                end = currEnd;
            }

            else{
                start = Math.min(start, currStart);
                end = Math.max(end, currEnd);
            }
        } 
        if(list.size()==0 ||  list.get(list.size()-1).get(1) != end){
            list.add(new ArrayList<>(Arrays.asList(start, end)));
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i][0]=list.get(i).get(0);
            ans[i][1]=list.get(i).get(1);
        }
        return ans;
    }
}