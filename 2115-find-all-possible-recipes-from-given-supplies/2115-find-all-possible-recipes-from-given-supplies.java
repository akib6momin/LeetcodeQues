class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>();
        for(String s:supplies){
            available.add(s);
        }

        int n = recipes.length;
        int indegree[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();

        for(int i=0; i<ingredients.size(); i++){
            for(String ingd : ingredients.get(i)){

                if(!available.contains(ingd)){
                    indegree[i]++;
                }

                if(!map.containsKey(ingd)){
                    map.put(ingd, new ArrayList<>());
                }

                map.get(ingd).add(i);
            }

            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<String> result = new ArrayList<>();

        while(!q.isEmpty()){
            String curr = recipes[q.poll()];
            result.add(curr);
            available.add(curr);

            for(int next : map.getOrDefault(curr, new ArrayList<>())){
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }

        return result;

    }

}