class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 1});
        grid[0][0]=1;

        int dr[] = {-1, 0, 1, 0, -1, 1, 1, -1};
        int dc[] = {0, -1, 0, 1, 1, 1, -1, -1};

        while(!q.isEmpty()){
            int cell[] = q.poll();
            int r = cell[0];
            int c = cell[1];
            int curr = cell[2];

            if(r==n-1 && c==n-1){
                return curr;
            }

            for(int i=0; i<8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                    grid[nr][nc] = 1;
                    q.offer(new int[]{nr, nc, curr+1});
                }
            }
        }

        return -1;
    }
}