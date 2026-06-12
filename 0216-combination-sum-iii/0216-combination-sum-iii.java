class Solution {
    public void generate(int k, int target, int i, ArrayList<Integer> l, List<List<Integer>> list){
        
        if(target == 0 && k==0){
            list.add(new ArrayList<>(l));
            return;
        } 

        for(int j=i;j<=9;j++){
            if(target-j < 0 || k==0)break;

            l.add(j);
            generate(k-1, target-j, j+1, l, list);
            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();

        generate(k, n, 1, new ArrayList<>(), list);
        return list;
    }
}