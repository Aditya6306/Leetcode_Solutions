class Solution {
    
    public boolean[] transformStr(String s, String[] strs) {
        
        boolean ans[] = new boolean[strs.length];
        int a=0;
        int fixedOnes = 0;
        for(char c : s.toCharArray()){
            if(c=='1') fixedOnes++;
        }
        for(String st : strs){
            int tempOnes=0;
            int ques=0;
            for(char c : st.toCharArray()){
                if(c=='1'){
                    tempOnes++;

                }
                if(c=='?')ques++;

            }

            if(fixedOnes < tempOnes || tempOnes+ques < fixedOnes){
                ans[a++] = false;
                continue;
            }

            int rqdOnes = fixedOnes - tempOnes;

            char[] ch = st.toCharArray();

            for(int i=ch.length-1; i>=0;i--){
                if(st.charAt(i) == '?'){
                    if(rqdOnes > 0){
                        ch[i]='1';
                        rqdOnes--;
                    }
                    else{
                        ch[i]='0';
                    }
                }
            }

            int x=0;
            int y=0;
            boolean flag=true;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '1') x++;
                if(ch[i] == '1') y++;

                if(y>x){
                    flag=false;
                    break;
                }
            }
            ans[a++]=flag;
        }
        return ans;
    }
}