class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[numCourses];
        int result[] = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int pair[]: prerequisites){
            int course = pair[0];
            int depends = pair[1];

            adj.get(depends).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int index = -1;

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            result[++index]=node;
            for(int child : adj.get(node)){
                indegree[child]--;
                if(indegree[child]==0){
                    q.offer(child);
                }
            }
        }

        return (index==numCourses-1) ? result : new int[]{};
    }
}