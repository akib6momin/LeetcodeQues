class Solution {

    public class DSU{
        int parent[];
        int size[];
        int componets;

        public DSU(int n){
            parent = new int[n];
            size = new int[n];
            componets = n;

            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x]!=x){
                return find(parent[x]);
            }

            return parent[x];
        }

        public void union(int x, int y){

            int parentX = find(x);
            int parentY = find(y);

            if(parentX==parentY){
                return;
            }

            if(size[parentY] < size[parentX]){
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            }else{
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            }

            componets--;
        }
    }

    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1){
            return -1;
        }

        DSU dsu = new DSU(n);

        for(int edge[]: connections){
            dsu.union(edge[0], edge[1]);
        }

        return dsu.componets-1;
    }
}