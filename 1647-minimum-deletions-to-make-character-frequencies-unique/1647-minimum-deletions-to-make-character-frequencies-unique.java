class Solution {
    public int minDeletions(String s) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int ans=0;
        for(char key : map.keySet()){
            int freq=map.get(key);
            int temp=freq;
            while(temp>0 && set.contains(temp)) temp--;
            ans += freq-temp;
            set.add(temp); 
        }
        return ans;
    }
}