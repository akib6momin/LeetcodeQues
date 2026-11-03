class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        int safe[][] = new int[n][m];

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){
                if(i>0 && i<n-1 && j>0 && j<m-1){
                    continue;
                }

                if(board[i][j]=='O' ){
                    dfs(board, i, j, safe);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O' && safe[i][j]!=1){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c, int[][] safe){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]=='X' || safe[r][c]==1){
            return;
        }

        safe[r][c] = 1;

        dfs(board, r-1, c, safe);
        dfs(board, r, c-1, safe);
        dfs(board, r+1, c, safe);
        dfs(board, r, c+1, safe);

    }
}