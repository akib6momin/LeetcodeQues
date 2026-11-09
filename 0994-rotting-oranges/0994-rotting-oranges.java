class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length; 
        int m = grid[0].length;
        int fresh = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0){
            return 0;
        }

        return bfs(q, grid, fresh);
    }

    public int bfs(Queue<int[]> q, int grid[][], int fresh){
        int ans = 0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, -1, 0, 1};

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotten = false;

            for(int i=0; i<size; i++){
                int cell[] =q.poll();
                int r = cell[0];
                int c = cell[1];

                for(int j=0; j<4; j++){
                    int nr = r+dr[j];
                    int nc = c+dc[j];

                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        rotten = true;
                        q.offer(new int[]{nr, nc});
                        grid[nr][nc]=2;
                        fresh--;
                    }
                }
            }

            if(rotten){
                ans++;
            }
        }

        return (fresh==0) ? ans : -1;
    }
}