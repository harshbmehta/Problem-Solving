/*
Time: O(h)
Space: O(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }

    public boolean recurseTree(TreeNode current, TreeNode p, TreeNode q) {
        if(current == null) {
            return false;
        }

        int left = recurseTree(current.left, p, q)? 1: 0;
        int right = recurseTree(current.right, p, q)? 1: 0;

        int mid = (current == p || current == q)? 1: 0;

        if(mid+left+right>=2) {
            this.ans = current;
        }

        return (mid+left+right>0);
    }
}