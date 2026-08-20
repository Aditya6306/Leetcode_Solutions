class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] arr = path.split("/+");
        
        
        for(int i=1;i<arr.length;i++){
            String ele = arr[i];
            if(ele.equals(".")) continue;
            else if(ele.equals("..") ){
                if(!st.isEmpty()) st.pop();
            } 
            else st.add(ele);
        }
        
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            String s = "/"+st.pop();
            ans.insert(0, s);
        }
        if(ans.length() == 0) ans.append("/");
        return ans.toString();
    }
}