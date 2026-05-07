class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums) map.put(ele, map.getOrDefault(ele, 0)+1);

        int ans=0;
        for(int ele : map.keySet()){
            int freq = map.get(ele);
            if(freq<=1) return -1;
            ans += (int)(Math.ceil(freq/3.0));
            System.out.println(ans);
        }
        return ans;
    }
}