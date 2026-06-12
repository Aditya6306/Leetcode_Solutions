class Solution {
    String[] st = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void generate(int i, String s, ArrayList<String> list, String digits){
        if(s.length() == digits.length()) {
            list.add(s);
            return;
        }

        String str = st[(digits.charAt(i)-'0')-2];

        for(char c : str.toCharArray()){
            generate(i+1, s+c, list, digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        
        // String[] st = {abc, def, ghi, jkl, mno, pqrs, tuv, wxyz};

        ArrayList<String> ans = new ArrayList<>();
        
        generate(0, "", ans, digits);
        return ans;
    }
}