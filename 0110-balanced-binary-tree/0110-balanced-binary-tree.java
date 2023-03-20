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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        heightDiff(root);
        return res;
    }

    private int heightDiff(TreeNode node) {
        if(node == null) {
            return -1;
        }
        int left = 1 + heightDiff(node.left);
        int right = 1 + heightDiff(node.right);

        if(Math.abs(left-right) > 1) {
            res = false;
        }
        return Math.max(left,right);
    }
}