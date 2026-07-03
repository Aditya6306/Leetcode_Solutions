class Solution {
    public int calculate(ArrayList<Integer> list, int i, int j, int[][] dp){
        if(i>j)return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min=Integer.MAX_VALUE;

        for(int k=i;k<=j;k++){
            int count = (list.get(j+1)-list.get(i-1)) + calculate(list, i, k-1, dp) + calculate(list, k+1, j, dp);
            min=Math.min(min, count);
        }

        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int ele : cuts) list.add(ele);
        list.add(0, 0);
        list.add(list.size(), n);
        Collections.sort(list);
        int[][] dp = new int[list.size()][list.size()];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return calculate(list, 1, list.size()-2, dp);
    }
}