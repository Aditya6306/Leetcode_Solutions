class Solution {
    public int calculate(List<List<Integer>> list, int i, int j, ArrayList<ArrayList<Integer>> l){
        if(i==list.size()-1){
            return list.get(i).get(j);
        }
        if(l.get(i).get(j) != Integer.MIN_VALUE)return l.get(i).get(j);
        int bottom = list.get(i).get(j)+calculate(list, i+1, j, l);
        int bottomRight = list.get(i).get(j)+calculate(list, i+1, j+1, l);
        int ans = Math.min(bottom, bottomRight);
        l.get(i).set(j,ans);
        return ans;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<triangle.size();i++){
            ArrayList<Integer> l1 = new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++){
                l1.add(Integer.MIN_VALUE);
            }
            list.add(l1);
        }
        System.out.println(list);
        return calculate(triangle, 0, 0, list);
        
    }
}