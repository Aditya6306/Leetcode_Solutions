class Solution {
    public int calculate(ArrayList<Integer> list, int i, int j, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max=Integer.MIN_VALUE;

        for(int k=i; k<=j;k++){
            int count = (list.get(i-1)*list.get(k)*list.get(j+1)) + calculate(list, i, k-1, dp) + calculate(list, k+1, j, dp);

            max = Math.max(max, count);
        }
        return dp[i][j] = max;
    }
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : nums) list.add(ele);
        list.add(0, 1);
        list.add(list.size(), 1);
        // System.out.println(list);
        int dp[][] = new int[list.size()][list.size()];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return calculate(list, 1, list.size()-2, dp);
    }
}