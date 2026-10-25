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
// class Solution {

//     public TreeNode deleteNode(TreeNode root, int key) {
//         if(root==null){
//             return root;
//         }

//         if(root.val==key){
            
//             TreeNode left = root.left;
//             TreeNode right = root.right;

//             if(left==null && right==null){
//                 return null;
//             }else if(left==null){
//                 return root.right;
//             }else if(right==null){
//                 return root.left;
//             }else{
//                 TreeNode curr = left;
//                 while(curr.right!=null){
//                     curr = curr.right;
//                 }
//                 curr.right = right;
//                 return left;
//             }
//         }
//         removeNode(root, null, key, true);
//         return root;
//     }

//     public void removeNode(TreeNode root, TreeNode parent, int key, boolean dir){

//         if(root==null){
//             return;
//         }

//         if(root.val==key){
            
//             TreeNode left = root.left;
//             TreeNode right = root.right;

//             if(left==null && right==null){
//                 attach(null, parent, dir);
//             }else if(left==null){
//                 attach(right, parent, dir);
//             }else if(right==null){
//                 attach(left, parent, dir);
//             }else{
//                 attach(left, parent, dir);
//                 TreeNode curr = left;
//                 while(curr.right!=null){
//                     curr = curr.right;
//                 }
//                 curr.right = right;
//             }
//             return;
//         }

//         if(key<root.val){
//             removeNode(root.left, root, key, true);
//         }else{
//             removeNode(root.right, root, key, false);
//         }
//     }

//     public void attach(TreeNode node, TreeNode parent, boolean dir){
//         if(dir){
//             parent.left = node;
//         }else{
//             parent.right = node;
//         }
//     }

// }

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            TreeNode succ = getMin(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }

        return root;
    }

    public TreeNode getMin(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }

        return root;
    }

}