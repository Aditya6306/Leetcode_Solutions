class Solution {
    public int equalPairs(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][0] == grid[0][j]){
                    int k=0;
                    while(k<grid.length && grid[i][k] == grid[k][j]) k++;
                    if(k== grid.length) ans++;
                }
            }
        }
        return ans;
    }
}