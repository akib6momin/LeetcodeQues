/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Using DFS
// class Solution {
//     public List<Double> averageOfLevels(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
//         List<Double> ans = new ArrayList<>();
//         findLevelWiseNodes(root, list, 0);

//         for(List<Integer> outer : list){
//             double sum = 0.0;
//             double cnt = 0.0;
//             for(int val : outer){
//                 sum+=val;
//                 cnt++;
//             }
//             ans.add(sum/cnt);
//         }

//         return ans;
//     }

//     public void findLevelWiseNodes(TreeNode root, List<List<Integer>> list, int level){
//         if(root==null){
//             return;
//         }

//         if(level==list.size()){
//             list.add(new ArrayList<>());
//         }

//         list.get(level).add(root.val);

//         findLevelWiseNodes(root.left, list, level+1);
//         findLevelWiseNodes(root.right, list, level+1);
//     }
// }

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        
        if(root==null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0.0;

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();

                sum+=node.val;

                if(node.left!=null){
                    q.offer(node.left);
                }

                if(node.right!=null){
                    q.offer(node.right);
                }
            }

            ans.add(sum/size);
        }

        return ans;
    }
}