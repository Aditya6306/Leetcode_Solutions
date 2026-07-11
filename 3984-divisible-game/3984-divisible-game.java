class Solution {
    int mod = (int)1e9+7;
    public void generate(int nums[], HashMap<Integer, ArrayList<Integer>> map) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                if (map.containsKey(2)) {
                    map.get(2).add(i);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(2, list);
                }
            } else if (nums[i] == 3) {
                if (map.containsKey(3)) {
                    map.get(3).add(i);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(3, list);
                }
            } else {
                for (int j = 2; j * j <= nums[i]; j++) {
                    if (nums[i] % j == 0) {
                        if (map.containsKey(j)) {
                            map.get(j).add(i);
                        } else {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(i);
                            map.put(j, list);
                        }
                        if (map.containsKey(nums[i] / j)) {
                            map.get(nums[i] / j).add(i);
                        } else {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(i);
                            map.put(nums[i] / j, list);
                        }

                    }
                }
            }

        }
    }
    public boolean isPrime(int n){
        for(int i=3;i*i<=n;i=i+2){
            if(n%i == 0) return false;
        }
        return true;
    }
    public void generate(ArrayList<Integer> list, int max){
        list.add(2);
        int i=3;
        while(i<=max){
            if(isPrime(i))list.add(i);
            i=i+2;
        }

    }
    public int divisibleGame(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            max=Math.max(max, nums[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        generate(list, max);
        System.out.println(list);
        long preScore=Integer.MIN_VALUE;
        long preK=0;
        for(int i=0;i<list.size();i++){
            int k=list.get(i);
            int currScore=nums[0]%k==0 ? nums[0] : -nums[0];
            int maxSc=nums[0]%k==0 ? nums[0] : -nums[0];
            for(int j=1;j<nums.length;j++){
                if(nums[j]%k == 0){
                    currScore = Math.max(currScore+nums[j], nums[j]);
                }
                else{
                    currScore = Math.max(currScore-nums[j], -nums[j]);
                }

                if(currScore > maxSc){
                    maxSc = currScore;
                }
            }
            if(maxSc > preScore){
                preScore = (long)maxSc;
                preK=(long)k;
            }
        }
        System.out.println(preScore);
        System.out.println(preK);
        System.out.println((preK*preScore)%mod);
        return (int)((preK * preScore) % mod + mod) % mod;
    }
}