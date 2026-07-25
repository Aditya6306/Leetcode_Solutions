class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });

        for(int i=0;i<profits.length;i++){
            if(capital[i]<=w) pq.add(profits[i]);
            else{
                int[] arr = {profits[i], capital[i]};
                pq2.add(arr);
            }
        }

        int ans=0;
        while(k>0 && pq.size()>0){
            int t=pq.remove();
            ans += t;
            w += t;
            while(!pq2.isEmpty() && pq2.peek()[1]<=w){
                pq.add(pq2.remove()[0]);
            }
            k--;
        }
        return w;
    }
}