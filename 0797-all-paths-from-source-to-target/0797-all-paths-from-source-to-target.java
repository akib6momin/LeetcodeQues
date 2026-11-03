class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pathNodes = new ArrayList<>();

        findPaths(0, result, pathNodes, graph, graph.length-1);

        return result;
    }

    public void findPaths(int node, List<List<Integer>> result, List<Integer> pathNodes, int[][] graph, int target){

        pathNodes.add(node);
        if(node == target){
            result.add(new ArrayList<>(pathNodes));
        }

        for(int child: graph[node]){
            findPaths(child, result, pathNodes, graph, target);
        }

        if(pathNodes.size()>0){
            pathNodes.remove(pathNodes.size()-1);
        }
    }
}