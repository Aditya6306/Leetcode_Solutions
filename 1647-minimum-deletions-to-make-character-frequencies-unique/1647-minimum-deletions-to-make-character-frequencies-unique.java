class Solution {
    public int minDeletions(String s) {
        int[] map = new int[26];
        for(char c : s.toCharArray()) map[c-'a']++;

        Arrays.sort(map);

        int ans=0;
        int i=24;
        while(i>=0){
            if(map[i] == 0) break;
            if(map[i]>=map[i+1]){
                int freq=map[i];
                map[i]=Math.max(0,map[i+1]-1);
                ans += freq-map[i];
            }
            i--;
        }
        return ans;
    }
}