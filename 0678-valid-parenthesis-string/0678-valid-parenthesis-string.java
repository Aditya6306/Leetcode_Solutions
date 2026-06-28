class Solution {
    
    public boolean checkValidString(String s) {
        int minOp = 0;
        int maxOp = 0;
        int j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(ch == '('){
                minOp++;
                maxOp++;
            }
            else if(ch == ')'){
                minOp--;
                maxOp--;
            }
            else{
                minOp--;
                maxOp++;
                
            }
            if(minOp < 0) minOp=0;
            if(maxOp < 0) return false;
            j++;
        }
        return minOp == 0;
    }
}