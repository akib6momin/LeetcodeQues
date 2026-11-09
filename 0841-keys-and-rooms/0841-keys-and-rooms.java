class Solution {

    int visitedCnt;
    boolean visited[];

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visitedCnt = 0;
        visited = new boolean[rooms.size()];

        bfs(0, rooms);

        return visitedCnt == rooms.size();
    }

    public void bfs(int node , List<List<Integer>> rooms){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        visitedCnt++;

        while(!q.isEmpty()){
            int parent = q.poll();
            for(int child: rooms.get(parent)){
                if(!visited[child]){
                    q.offer(child);
                    visited[child]=true;
                    visitedCnt++;
                }
            }
        }
    }
}