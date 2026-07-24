class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans= new ArrayList<>();

        int j=0;
        while(j<words.length){
            ArrayList<String> l = new ArrayList<>();
            int len=0;
            while(j<words.length && len+words[j].length()+l.size() <= maxWidth){
                len += words[j].length();
                l.add(words[j]);
                j++;
            }
            int gap = l.size()-1;
            
            int rem = maxWidth-len;
            System.out.println(rem+" "+gap);
            String str="";
            if(gap == 0 || j==words.length){
                for(int i=0;i<l.size();i++){
                    if(i!=0){
                        str+=" ";
                    }
                    str += l.get(i);
                }
                
                while(str.length()<maxWidth) str+=" ";
                
                ans.add(str);
            }

            else{
                int tot=rem/gap;
                int extra = rem%gap;
                for(int i=0;i<l.size();i++){
                    if(i!=0){
                        str += " ".repeat(tot);
                        if(extra>0) str += " ";
                        extra--;
                    }
                    str += l.get(i);
                }
                
                ans.add(str);
            }
            
        }
        return ans;
    }
}