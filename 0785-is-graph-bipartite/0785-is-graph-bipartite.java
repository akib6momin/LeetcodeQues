class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];

        for(int i=0; i<graph.length; i++){
            if(visited[i]==0){
                if(!dfs(i, 1, graph, visited)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int color, int graph[][], int visited[]){
        visited[node]=color;

        for(int child: graph[node]){
            if(visited[child]==0){
                if(!dfs(child, -color, graph, visited)){
                    return false;
                }
            }else{
                if(visited[child]==color){
                    return false;
                }
            }

        }

        return true;
    }
}