class Solution {
    public int hIndex(int[] citations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int ele : citations){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        int ans=0;
        int curr=0;
        for(int key : map.descendingKeySet()){
            curr+=map.get(key);
            int temp = Math.min(curr, key);
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}