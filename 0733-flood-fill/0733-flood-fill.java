class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];

        if(original == color){
            return image;
        }

        dfs(sr, sc, image, original, color);

        return image;
    }

    public void dfs(int r, int c,int[][] image, int original, int color){
        if(r<0 || r>=image.length || c<0 || c>=image[0].length || image[r][c]!=original){
            return;
        }

        image[r][c] = color;

        dfs(r+1, c, image, original, color);
        dfs(r, c+1, image, original, color);
        dfs(r-1, c, image, original, color);
        dfs(r, c-1, image, original, color);
    }
}