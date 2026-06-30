class Solution {
    public String generate(String s, int i, int j){
        if(i==-1 || j==0){
            return "";
        }

        String ans="";
        String st="";
        String str = "";
        if(s.charAt(i) == s.charAt(j)){
            st+=generate(s, i-1, j-1)+s.charAt(i);
        }
        else{
            str += generate(s, i-1, s.length()-1);
        }
        if(st.length() > str.length() && i==0) ans=st;
        else if(st.length() < str.length() && i==0)  ans=str;

        return ans;

    }
    public String longestPrefix(String s) {
        int n=s.length();
        int[] arr = new int[n];

        arr[0] = 0;
        int length=0;
        int j=1;
        while(j<s.length()){
            
            if(s.charAt(j) == s.charAt(length)) {
                length++;
                arr[j]=length;
                j++;
            }
            else{
                if(length>0){
                    length=arr[length-1];
                }
                else{
                    j++;
                }
            }

        }
        String st="";
        int k=0;
        System.out.println(arr[n-1]);
        while(k<arr[n-1]){
            st+=s.charAt(k);
            k++;
        }
        return st;
    }
}