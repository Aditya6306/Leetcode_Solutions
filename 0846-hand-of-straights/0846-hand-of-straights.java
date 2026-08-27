class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if(hand.length % groupSize != 0) return false;
        for(int ele : hand){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        while(map.size()>0){
            int t=groupSize;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
            int pre=-1;
            while(it.hasNext()){
                Map.Entry<Integer, Integer> entry = it.next();
                int key = entry.getKey();
                
                int freq = entry.getValue();
                it.remove();
                if(pre==-1) pre = key;
                else{
                    if(pre+1 != key) return false;
                    else pre=key;
                }
                if(freq != 1){
                    list.add(new ArrayList<>(Arrays.asList(key, freq-1)));
                }
                t--;
                if(t==0) break;
            }
            if(t>0) return false;
            int i=0;
            while(i<list.size()){
                map.put(list.get(i).get(0), list.get(i).get(1));
                i++;
            }
        }
        return true;
    }
}