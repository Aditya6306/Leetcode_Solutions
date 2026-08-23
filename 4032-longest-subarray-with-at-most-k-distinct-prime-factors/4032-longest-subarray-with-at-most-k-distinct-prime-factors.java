class Solution {
    public void generate(int[] spf, int max){
        for(int i=2;i<=max;i++){
            if(spf[i]==0){
                spf[i]=i;
                if((long)i*i <= max){
                    for(int j=i*i;j<=max;j=j+i){
                        if(spf[j]==0) spf[j]=i;
                    }
                }
                
            }
        }
    }
    public int longestSubarray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int ele : nums) max = Math.max(ele, max);

        int[] spf = new int[max+1];
        generate(spf, max);
        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<ArrayList<Integer>> cont = new ArrayList<>();
        
        for(int ele : nums){
            ArrayList<Integer> l = new ArrayList<>();
            while(ele > 1){
                l.add(spf[ele]);
                int curr=spf[ele];
                while(ele>1 && ele % curr == 0){
                    ele = ele/curr;
                }
            }
            cont.add(l);
        }
        
        int l=0, r=0;
        int ans=0;
        while(r<nums.length){
            ArrayList<Integer> ls = cont.get(r);
            int j=0;
            while(j<ls.size()){
                map.put(ls.get(j), map.getOrDefault(ls.get(j), 0)+1);
                j++;
            }
            if(map.size()>k){
                
                while(map.size()>k){
                    ArrayList<Integer> li = cont.get(l);
                    j=0;
                    while(j<li.size()){
                        map.put(li.get(j), map.get(li.get(j))-1);
                        if(map.get(li.get(j)) == 0) map.remove(li.get(j));
                        j++;
                    }
                    l++;
                }
            }
            ans = Math.max(r-l+1, ans);

            r++;
        }

        return ans;
    }
}