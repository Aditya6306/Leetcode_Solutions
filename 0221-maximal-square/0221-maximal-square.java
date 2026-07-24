class Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0;
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0){
                    max = Math.max(max, matrix[i][j]-'0');
                }
                else if(matrix[i][j] == '0'){
                    int temp=Math.max(matrix[i-1][j-1]-'0', Math.max(matrix[i][j-1]-'0', matrix[i-1][j]-'0'));
                    max=Math.max(temp, max);
                    continue;
                }
                else{
                    int min = Math.min(matrix[i-1][j-1]-'0', Math.min(matrix[i][j-1]-'0', matrix[i-1][j]-'0'))+1;
                    matrix[i][j] = (char)(min+'0');
                    max=Math.max(max, min);
                }
            }
        }
        
        return max*max;
    }
}