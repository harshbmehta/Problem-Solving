/*
Time complexity: O(MN). For every N node in the tree, we check if the tree rooted at node is identical to subRoot. This check takes O(M) time, where M is the number of nodes in subRoot. Hence, the overall time complexity is O(MN).

Space complexity: O(M+N)

There will be at most N recursive call to dfs ( or isSubtree). Now, each of these calls will have M recursive calls to isIdentical. Before calling isIdentical, our call stack has at most O(N) elements and might increase to O(N+M) during the call. After calling isIdentical, it will be back to at most O(N)since all elements made by isIdentical are popped out. Hence, the maximum number of elements in the call stack will be M+N.
*/

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }

        if(root == null || subRoot == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return (
            isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
        );
    }

    private boolean isSameTree(TreeNode r,TreeNode subRoot) {
        if(r == null && subRoot == null) {
            return true;
        }

        if(r == null || subRoot == null) {
            return false;
        }

        if(r.val != subRoot.val) return false;

        return isSameTree(r.left, subRoot.left) && isSameTree(r.right, subRoot.right);
    }
}