class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] arr, int freeStart, int freeEnd) {
        Arrays.sort(arr, (a, b)->{
            return a[0]-b[0];
        });
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(arr[0][0]);
        l.add(arr[0][1]);
        list.add(l);
        for(int i=1;i<arr.length;i++){
            int n=list.size();
            int preEnd = list.get(n-1).get(1);
            int currStart = arr[i][0];
            if(preEnd+1 >= currStart){
                list.get(n-1).set(1, Math.max(preEnd, arr[i][1]));
            }
            else{
                List<Integer> ls = new ArrayList<>();
                ls.add(arr[i][0]);
                ls.add(arr[i][1]);
                list.add(ls);
            }
        }
        // System.out.println(list);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            int currStart = list.get(i).get(0);
            int currEnd = list.get(i).get(1);

            if(currEnd < freeStart){
                ans.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
            }
            else if(freeEnd<currStart){
                ans.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
            }
            else{
                
                if(currStart < freeStart){
                    ans.add(new ArrayList<>(Arrays.asList(currStart, freeStart-1)));
                }
                if(freeEnd<currEnd){
                    ans.add(new ArrayList<>(Arrays.asList(freeEnd+1, currEnd)));
                }
            }

        }
        return ans;
    }
}