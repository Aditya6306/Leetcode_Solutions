class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            int[][] arr = new int[1][2];
            arr[0][0] = newInterval[0];
            arr[0][1] = newInterval[1];
            return arr;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;
        for(int i=0;i<intervals.length;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currEnd < start){ // before
                list.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
            }
            else if( currStart > end){
                if(!inserted){
                    list.add(new ArrayList<>(Arrays.asList(start, end)));
                    inserted = true;
                }
                
                list.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
                
            }
            else{
                start = Math.min(start, currStart);
                end = Math.max(end, currEnd);
                if(i==intervals.length-1){
                    list.add(new ArrayList<>(Arrays.asList(start, end)));
                }
            }
        }
        int n=intervals.length;
        if(start > intervals[n-1][1]){
            list.add(new ArrayList<>(Arrays.asList(start, end)));
        }
        
        System.out.println(list);
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i][0]=list.get(i).get(0);
            ans[i][1]=list.get(i).get(1);
        }
        return ans;
    }
}