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
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return root;
        }

        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);

        while(!stk.isEmpty()) {
            TreeNode top = stk.pop();
            TreeNode left = top.left;
            top.left = top.right;
            top.right = left;

            if(top.left != null) {
                stk.push(top.left);
            }

            if(top.right != null) {
                stk.push(top.right);
            }
        }
        return root;

        // Recursive solution
        // public TreeNode invertTree(TreeNode root) {
        
        // if (root == null) {
        //     return null;
        // }

        // final TreeNode left = root.left,
        //         right = root.right;
        // root.left = invertTree(right);
        // root.right = invertTree(left);
        // return root;
    
    }
}