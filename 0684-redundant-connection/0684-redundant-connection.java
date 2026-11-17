class Solution {
    int size[];
    int parent[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        size = new int[n+1];
        parent = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int edge[]: edges){
            if(union(edge[0], edge[1])){
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[]{-1, -1};
    }

    public boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX==parentY){
            return true;
        }else if(size[parentX] < size[parentY]){
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }else{
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        }

        return false;
    }

    public int find(int x){
        if(parent[x]!=x){
            return find(parent[x]);
        }

        return parent[x];
    }
}