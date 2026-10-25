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

class Pair{
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}


class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return find(root).node;
    }

    public Pair find(TreeNode root){
        if(root==null){
            return new Pair(null, 0);
        }

        Pair left = find(root.left);
        Pair right = find(root.right);

        if(left.level==right.level){
            return new Pair(root, left.level+1);
        }

        if(left.level > right.level){
            return new Pair(left.node, left.level+1);
        }

        return new Pair(right.node, right.level+1);
    }
}