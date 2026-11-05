class Solution {
    int time;
    int dt[];
    int low[];

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        time = 0;
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dt = new int[n];
        low = new int[n];

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<connections.size(); i++){
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, visited, adj, -1, result);
            }
        }

        return result;
    }

    public void dfs(int node, boolean visited[], List<List<Integer>> adj, int parent, List<List<Integer>> result){
        visited[node]=true;
        dt[node] = low[node] = ++time;

        for(int child : adj.get(node)){
            if(!visited[child]){
                dfs(child, visited, adj, node, result);
                low[node] = Math.min(low[child], low[node]);
                if(low[child]>dt[node]){
                    result.add(Arrays.asList(node, child));
                }
            }else if(child!=parent){
                low[node] = Math.min(low[node], dt[child]);
            }
        }
    }
}