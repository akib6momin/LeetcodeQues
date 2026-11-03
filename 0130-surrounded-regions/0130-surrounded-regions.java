class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;


        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){
                if(i>0 && i<n-1 && j>0 && j<m-1){
                    continue;
                }

                if(board[i][j]=='O' ){
                    dfs(board, i, j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]=='X' || board[r][c]=='S'){
            return;
        }

        board[r][c] = 'S';

        dfs(board, r-1, c);
        dfs(board, r, c-1);
        dfs(board, r+1, c);
        dfs(board, r, c+1);

    }
}