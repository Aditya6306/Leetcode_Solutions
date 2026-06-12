class Solution {
    public void helper(String s, int cl, int op, ArrayList<String> list, int n){
        if(cl == op && op == n){
            list.add(s);
            return;
        }

        if(op<n) helper(s+'(', cl, op+1, list, n);
        if(cl<op) helper(s+')', cl+1, op, list, n);
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();

        helper("", 0, 0, list, n);

        return list;
    }
}