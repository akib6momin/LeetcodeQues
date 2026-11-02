class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    public void bfs(char[][] grid, int r, int c){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c]=0;

        while(!q.isEmpty()){
            int[] rowcol = q.poll();

            int dr[] = {-1, 0, 1, 0};
            int dc[] = {0, -1, 0, 1};

            for(int i=0; i<4; i++){
                int newR = rowcol[0]+dr[i];
                int newC = rowcol[1]+dc[i];

                if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]=='1'){
                    q.offer(new int[]{newR, newC});
                    grid[newR][newC]=0;
                }
            }
        }
    }
}