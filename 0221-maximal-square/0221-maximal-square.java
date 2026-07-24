class Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0;
        for(int i=0;i<matrix.length;i++){
            max = Math.max(max, matrix[i][0]-'0');
        }
        for(int i=0;i<matrix[0].length;i++){
            max = Math.max(max, matrix[0][i]-'0');
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                else{
                    int min = Math.min(matrix[i-1][j-1]-'0', Math.min(matrix[i][j-1]-'0', matrix[i-1][j]-'0'))+1;
                    matrix[i][j] = (char)(min+'0');
                    max=Math.max(max, min);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        return max*max;
    }
}