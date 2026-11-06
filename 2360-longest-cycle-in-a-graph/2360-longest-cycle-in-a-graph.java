class Solution {
    int ans = -1;                               
    public int longestCycle(int[] edges) {
        ans = -1;
        boolean visited[] = new boolean[edges.length];
        int pathVisited[] = new int[edges.length];

        for(int i=0; i<edges.length; i++){
            if(!visited[i]){
                dfs(i, 1, visited, pathVisited, edges);
            }
        }

        return ans;
    }

    public void dfs(int node, int srno, boolean visited[], int pathVisited[], int edges[]){
        visited[node]=true;
        pathVisited[node]=srno;

        if(edges[node]!=-1 && pathVisited[edges[node]]!=0){
            ans = Math.max(ans, srno - pathVisited[edges[node]]+1);
        }else if(edges[node]!=-1 && !visited[edges[node]]){
            dfs(edges[node], srno+1, visited, pathVisited, edges);
        }

        pathVisited[node]=0;
    }
}