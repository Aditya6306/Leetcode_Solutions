class Solution {
    public boolean isFound(String s1, String s2){
        for(char c : s2.toCharArray()){
            if(s1.contains(""+c)) return true;
            
        }
        return false;
    }
    public boolean dup(String s){
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.isEmpty() && set.contains(c)) return true;
            set.add(c);
        }
        return false;
    }
    public int calculate(List<String> arr, int i, String st){
        if(i==arr.size()) return st.length();

        int take = 0;
        if(!isFound(st, arr.get(i)) && !dup(arr.get(i))) take = calculate(arr, i+1, st+arr.get(i));
        int skip = calculate(arr, i+1, st);

        return Math.max(take, skip);
    }
    public int maxLength(List<String> arr) {
        return calculate(arr, 0, "");
    }
}