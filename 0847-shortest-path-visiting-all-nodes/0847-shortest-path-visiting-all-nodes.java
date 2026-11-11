class Solution {

    class Pair{
        int node;
        int mask;

        public Pair(int node, int mask){
            this.node = node;
            this.mask = mask;
        }
    }


    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        if(n==0 || n==1){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][(1<<n)];
        int path = 0;
    

        int allVisited = (1 << n)-1; // this means Math.pow(2^n)-1

        for(int i=0; i<n; i++){
            int mask = (1 << i);
            q.offer(new Pair(i, mask));
            visited[i][mask]=true;
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                int node = p.node;
                int mask = p.mask;

                if(mask == allVisited){
                    return path;
                }

                for(int child : graph[node]){
                    int nextMask = mask | (1 << child);

                    if(!visited[child][nextMask]){
                        q.offer(new Pair(child, nextMask));
                        visited[child][nextMask]=true;
                    }
                }
            }

            path++;
        }

        return 0;
    }
}