class Solution {
    public char solve(char op, ArrayList<Character> list){
        if(op == '!'){
            if(list.get(0) == 't') return 'f';
            else return 't';
        }
        
        if(op=='&'){
            int i=0;
            while(i<list.size()){
                if(list.get(i) == 'f') return 'f';
                i++;
            }
            return 't';
        }
        if(op=='|'){
            int i=0;
            while(i<list.size()){
                if(list.get(i) == 't') return 't';
                i++;
            }
            return 'f';
        }
        return 'a';
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c != ')') st.push(c);
            else if(c==',') continue;
            else{
                ArrayList<Character> list = new ArrayList<>();

                while(st.peek() != '('){
                    list.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                char res = solve(op, list);
                st.push(res);
            }
        }

        return (st.peek() == 'f') ? false : true;
    }
}