class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            
            return b-a;
        });

        for(int c : map.values()){
            pq.add(c);

        }

        Queue<int[]> q = new LinkedList<>();
        int i=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            i++;
            if(!q.isEmpty() && q.peek()[1]==i){
                pq.add(q.poll()[0]);
            }

            if(!pq.isEmpty()){
                
                int freq = pq.poll();
                freq--;
                if(freq>0){
                    q.add(new int[]{freq, i+n+1});
                }
            }
            
        }
        return i;
    }
}