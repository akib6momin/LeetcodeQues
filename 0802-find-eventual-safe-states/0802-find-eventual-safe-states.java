class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int indegree[] = new int[n];

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            indegree[i]=graph[i].length;
            for(int next : graph[i]){
                adj.get(next).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            result.add(curr);

            for(int next : adj.get(curr)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }

        Collections.sort(result);

        return result;
    }
}