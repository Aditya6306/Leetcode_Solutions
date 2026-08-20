class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] arr = path.split("/+");
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"#");
        }
        
        for(int i=1;i<arr.length;i++){
            String ele = arr[i];
            if(ele.equals(".")) continue;
            else if(ele.equals("..") ){
                if(!st.isEmpty()) st.pop();
            } 
            else st.add(ele);
        }
        System.out.println(path.split("/+").length);
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            String s = "/"+st.pop();
            ans.insert(0, s);
        }
        if(ans.length() == 0) ans.append("/");
        return ans.toString();
    }
}