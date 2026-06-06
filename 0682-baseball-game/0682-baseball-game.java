class Solution {
    public int calPoints(String[] op) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<op.length;i++){
            String s = op[i];
            int n=list.size();
            if(s.equals("D")){
                list.add(list.get(n-1)*2);
            }
            else if(s.equals("C")){
                list.remove(n-1);
            }
            else if(s.equals("+")){
                list.add(list.get(n-1)+list.get(n-2));
            }
            else{
                int num = Integer.parseInt(s);
                list.add(num);
            }

        }
        int sum=0;
        for(int ele : list){
            sum += ele;
        }
        return sum;
    }
}