class Solution {
    public int countSquares(int[][] matrix) {
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0) continue;
                int a=matrix[i-1][j-1];
                int b=matrix[i-1][j];
                int c=matrix[i][j-1];
                int min = Math.min(a, Math.min(b, c));

                matrix[i][j] = 1+min;
            }
        }
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] != 0) ans += matrix[i][j];
            }
        }
        return ans;
    }
}