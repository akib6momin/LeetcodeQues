class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int depends = prerequisites[i][1];

            adj.get(depends).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int courseCCnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            courseCCnt++;
            for(int child : adj.get(node)){
                indegree[child]--;
                if(indegree[child]==0){
                    q.offer(child);
                }
            }
        }

        return courseCCnt == numCourses;
    }
}