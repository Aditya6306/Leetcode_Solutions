class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });
        for(int key : map.keySet()){
            int[] arr= {key, map.get(key)};
            pq.add(arr);
        }
        int[] ans = new int[k];
        int i=0;
        while(k>0){
            int[] arr=pq.remove();
            ans[i++]=arr[0];
            k--;
        }
        return ans;

    }
}