class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq=word.length();
        for(char c : word.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
            
        }

        int n=map.size();
        int[] arr = new int[n];
        int p=0;
        for(char key : map.keySet()){
            arr[p]=map.get(key);
            p++;
        }

        Arrays.sort(arr);
        int pre=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int currDel=0;
            for(int j=i+1;j<n;j++){
                if(i==j) continue;
                if(Math.abs(arr[i]-arr[j]) <= k) continue;
                currDel += Math.abs(arr[j]-arr[i])-k;
            }
            maxFreq = Math.min(maxFreq, currDel+pre);
            pre+=arr[i];
        }
        return maxFreq;
    }
}