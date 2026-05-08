class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);
        int ans=0;
        for(int i=1;i<arrays.size();i++){
            int len = arrays.get(i).size();
            int r1 = arrays.get(i).get(len-1)-min;
            int r2 = max-arrays.get(i).get(0);
            ans = Math.max(ans, Math.max(r1, r2));
            max = Math.max(max, arrays.get(i).get(len-1));
            min= Math.min(min, arrays.get(i).get(0));
        }
        return ans;
    }
}