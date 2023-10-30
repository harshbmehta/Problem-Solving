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
    // public int maxDepth(TreeNode root) {
    //     if(root == null) {
    //         return 0;
    //     }

    //     int left = 1 + maxDepth(root.left);
    //     int right = 1 + maxDepth(root.right);
        
    //     return Math.max(left, right);
    // }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.offer(root);
        int level = 0;

        while(!treeQ.isEmpty()) {
            int len = treeQ.size();
            for(int i=0; i< len; i++) {
                TreeNode curr = treeQ.poll();
                if(curr.left != null) {
                    treeQ.offer(curr.left);
                }

                if(curr.right != null) {
                    treeQ.offer(curr.right);
                }
            }
            level++;
        }
        return level;
    }
}