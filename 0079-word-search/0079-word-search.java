class Solution {
    public boolean helper(char[][] board, String word, int i, int j, int k){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        
        if(k==word.length()-1 && board[i][j] == word.charAt(k)) return true;
        if(board[i][j] != word.charAt(k)) return false;
        char c = board[i][j];
        board[i][j] = '.';

        boolean ans = helper(board, word, i+1, j, k+1) ||
                    helper(board, word, i, j+1, k+1)||
                    helper(board, word, i-1, j, k+1)||
                    helper(board, word, i, j-1, k+1);

        board[i][j]=c;
        return ans;

    }
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    ans = helper(board, word, i, j, 0);
                    if(ans) return ans;
                }
            }
        }
        return ans;
    }
}