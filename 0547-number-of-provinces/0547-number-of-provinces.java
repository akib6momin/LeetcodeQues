class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean visited[] = new boolean[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                ans++;
            }
        }

        return ans;
    }

    public void dfs(int node, int[][] isConnected, boolean visited[]){
        visited[node] = true;

        for(int i=0; i<isConnected[0].length; i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfs(i, isConnected, visited);
            }
        }
    }
}