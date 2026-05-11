class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int ele[] : matches){
            map.put(ele[1], map.getOrDefault(ele[1], 0)+1);
        }
        ArrayList<Integer> allMatchesWon = new ArrayList<>();
        ArrayList<Integer> oneMatchLost = new ArrayList<>();
        for(int[] ele : matches){
            if(!map.containsKey(ele[0])) {
                allMatchesWon.add(ele[0]);
                map.put(ele[0], 2);
            }
        }
        Collections.sort(allMatchesWon);
        ans.add(allMatchesWon);
        for(int key  :map.keySet()){
            if(map.get(key) == 1) oneMatchLost.add(key);
        }
        Collections.sort(oneMatchLost);
        ans.add(oneMatchLost);
        return ans;
        
    }
}