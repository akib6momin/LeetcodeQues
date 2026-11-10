class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean visited[] = new boolean[n*n+1];

        Queue<Integer> q = new LinkedList<>();
        visited[1]=true;
        q.offer(1);

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0; j<size; j++){
                int curr = q.poll();

                if(curr==n*n){
                    return moves;
                }

                for(int i=1; i<=6; i++){
                    int next = curr + i;

                    if(next > n*n){
                        break;
                    }

                    int cell[] = getRowCol(next, n);
                    int r = cell[0];
                    int c = cell[1];

                    if(board[r][c]!=-1){
                        next = board[r][c];
                    }

                    if(!visited[next]){
                        q.offer(next);
                        visited[next]=true;
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    public int[] getRowCol(int num, int n){
        int row = (n-1)-(num-1)/n;
        int col = (num-1)%n;

        if((n-row)%2==0){
            col = (n-1)-(num-1)%n;
        }

        return new int[]{row, col};
    }
}