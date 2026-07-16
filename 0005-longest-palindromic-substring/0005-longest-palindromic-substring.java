class Solution {
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int len=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String sub = s.substring(i, j);
                if(isPalindrome(sub) && sub.length()>len){
                    len=sub.length();
                    ans=sub;
                }
            }
        }
        return ans;
    }
}