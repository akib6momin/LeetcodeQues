class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        int dist[][] = new int[n][m];
        int dr[] ={-1, 0, 1, 0};
        int dc[] ={0, -1, 0, 1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i, j});
                }else{
                    dist[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && dist[nr][nc]==-1){
                    q.offer(new int[]{nr, nc});
                    dist[nr][nc] = dist[r][c]+1;
                }
            }
        }

        return dist;
    }
}