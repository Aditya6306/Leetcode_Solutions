class Solution {
    public int maximumGap(String skill, String station) {
        int n=skill.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int j=0;
        for(int i=0;i<station.length() && j<n;i++){
            if(skill.charAt(j) == station.charAt(i)) left[j++]=i;
        }
        j=n-1;
        for(int i=station.length()-1;i>=0 && j>=0 ;i--){
            if(skill.charAt(j) == station.charAt(i)) right[j--]=i;
        }
        
        int ans = 0;
        int i=0;
        j=1;
        while(j<n){
            int diff = right[j]-left[i];
            ans = Math.max(ans, diff);
            i++;
            j++;
        }
        return ans;
    }
}