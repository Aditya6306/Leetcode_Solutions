class Solution {
    public int strStr(String haystack, String needle) {
        int n=needle.length();
        int[] arr = new int[n];

        arr[0]=0;
        int length=0;
        int i=1;
        while(i<n){
            if(needle.charAt(i) == needle.charAt(length)){
                length++;
                arr[i]=length;
                i++;
            }
            else{
                if(length>0){
                    length=arr[length-1];
                }
                else i++;
            }
        }

        i=0;
        int j=0;
        while(j<haystack.length()){
            if(haystack.charAt(j) == needle.charAt(i)){
                i++;
                j++;
                if(i==needle.length()){
                    return j-needle.length();
                }
            }
            else{
                if(i>0) i=arr[i-1];
                else j++;
            }
        }
        return -1;
    }
}